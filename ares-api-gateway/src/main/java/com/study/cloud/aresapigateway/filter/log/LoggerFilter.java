package com.study.cloud.aresapigateway.filter.log;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.deploy.net.HttpUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/5/14 10:27
 */
@Component
public class LoggerFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();

        int responseStatusCode = currentContext.getResponseStatusCode();//请求状态码

        Long startTime = (Long) currentContext.get("startTime");//请求的开始时间，这个参数从前置的过滤器得到

        HttpServletRequest request = currentContext.getRequest();

        String method = request.getMethod();//请求方法

        String requestURI = request.getRequestURI();//请求URI

        Map<String, String[]> parameterMap = request.getParameterMap();//请求参数
        String params = parameterMap.toString();

        long duration = (System.currentTimeMillis()-startTime);//请求耗时

        return null;
    }
}
