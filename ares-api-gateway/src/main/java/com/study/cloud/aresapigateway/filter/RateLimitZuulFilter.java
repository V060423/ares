package com.study.cloud.aresapigateway.filter;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;

/**
 * @author wangbowen
 * @Description 使用 Google gugva 限流
 * 服务粒度
 * 用户粒度
 * ORIGIN粒度
 * 接口粒度
 *
 * @Date 2018/4/25 11:13
 */
@Component
public class RateLimitZuulFilter extends ZuulFilter {

    private Map<String, RateLimiter> map = Maps.newConcurrentMap();
//    @Autowired
//    public SystemPublicMetrics systemPublicMetrics;//Spring Boot Actuator提供，获取当前系统内存的一些指标
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //数字越大，优先级越低
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {
        //是否开启限流的开发,这里可以使用spring-boot-actuator提供的内存使用情况来判断是否开启
        // 这里可以考虑弄个限流开启的开关，开启限流返回true，关闭限流返回false，
//        Collection<Metric<?>> metrics = systemPublicMetrics.metrics();
//
//        Optional<Metric<?>> freeMemoryMetric = metrics.stream()
//
//                .filter(t -> "mem.free".equals(t.getName()))
//
//                .findFirst();
//
//        // 如果不存在这个指标，稳妥起见，返回true，开启限流
//
//        if (!freeMemoryMetric.isPresent()) {
//            return true;
//        }
//        long freeMemory = freeMemoryMetric.get()
//                .getValue()
//
//                .longValue();
//
//        // 如果可用内存小于1000000KB，开启流控
//        return freeMemory < 1000000L;
         return true;
    }

    @Override
    public Object run(){
        try {

            RequestContext context = RequestContext.getCurrentContext();

            HttpServletResponse response = context.getResponse();


            String key = null;

            // 对于service格式的路由，走RibbonRoutingFilter

            String serviceId = (String) context.get(SERVICE_ID_KEY);

            if (serviceId != null) {

                key = serviceId;

                map.putIfAbsent(serviceId, RateLimiter.create(1000.0));

            }

            // 如果压根不走RibbonRoutingFilter，则认为是URL格式的路由

            else {

                // 对于URL格式的路由，走SimpleHostRoutingFilter

                URL routeHost = context.getRouteHost();

                if (routeHost != null) {

                    String url = routeHost.toString();

                    key = url;

                    map.putIfAbsent(url, RateLimiter.create(2000.0));

                }

            }

            RateLimiter rateLimiter = map.get(key);

            if (!rateLimiter.tryAcquire()) {

                HttpStatus httpStatus = HttpStatus.TOO_MANY_REQUESTS;


                response.setContentType(MediaType.TEXT_PLAIN_VALUE);

                response.setStatus(httpStatus.value());

                response.getWriter().append(httpStatus.getReasonPhrase());


                context.setSendZuulResponse(false);

                throw new ZuulException(

                        httpStatus.getReasonPhrase(),

                        httpStatus.value(),

                        httpStatus.getReasonPhrase()

                );

            }

        } catch (Exception e) {

            ReflectionUtils.rethrowRuntimeException(e);

        }

        return null;

    }
}
