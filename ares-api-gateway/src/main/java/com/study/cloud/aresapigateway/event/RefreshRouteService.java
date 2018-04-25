package com.study.cloud.aresapigateway.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author wangbowen
 * @Description 刷新路由定位器
 * @Date 2018/4/25 14:45
 */
@Service
public class RefreshRouteService {
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private   RouteLocator routeLocator;

    public void refreshRoute() {
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }

}
