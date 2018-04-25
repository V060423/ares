package com.study.cloud.aresapigateway.config;

import com.study.cloud.aresapigateway.route.CustomRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 配置自定义定位器
 */
@Configuration
public class CustomZuulConfig {

    @Autowired
    private  ZuulProperties zuulProperties;
    @Autowired
    private ServerProperties server;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public CustomRouteLocator routeLocator() {
        CustomRouteLocator routeLocator = new CustomRouteLocator(server.getServlet().getServletPrefix(), zuulProperties);
        routeLocator.setJdbcTemplate(jdbcTemplate);
        return routeLocator;
    }

}
