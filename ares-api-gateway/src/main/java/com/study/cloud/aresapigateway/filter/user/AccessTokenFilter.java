package com.study.cloud.aresapigateway.filter.user;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/4/25 11:41
 */
@Component
public class AccessTokenFilter extends ZuulFilter {
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(String.format("%s AccessTokenFilter request to %s", request.getMethod(),
                request.getRequestURL().toString()));

        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
        ctx.setResponseBody("{\"name\":\"chhliu\"}");// 输出最终结果
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;// 在请求被处理之后，会进入该过滤器
    }
}
