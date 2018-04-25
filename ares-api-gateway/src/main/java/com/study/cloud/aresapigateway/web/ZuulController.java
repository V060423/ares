package com.study.cloud.aresapigateway.web;

import com.study.cloud.aresapigateway.event.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wangbowen
 * @Description 前端刷新controller
 * @Date 2018/4/25 14:51
 */
@RestController
public class ZuulController {
    @Autowired
    private RefreshRouteService refreshRouteService;

    @Autowired
    private ZuulHandlerMapping zuulHandlerMapping;

    @RequestMapping("/refreshRoute")
    public String refreshRoute(){
        refreshRouteService.refreshRoute();
        return "refreshRoute";
    }

    @RequestMapping("/watchNowRoute")
    public String watchNowRoute(){
        //可以用debug模式看里面具体是什么
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        return "watchNowRoute";
    }

}
