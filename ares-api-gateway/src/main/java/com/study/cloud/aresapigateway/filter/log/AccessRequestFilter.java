package com.study.cloud.aresapigateway.filter.log;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author wangbowen
 * @Description 请求路由之前过滤
 * @Date 2018/5/14 10:24
 */
@Component
public class AccessRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        //设置请求的开始时间
        RequestContext ctx = RequestContext.getCurrentContext();

        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}
