package com.fmh.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    /*@Value("${service-url.provide}")
    private String provideServiceUrl;*/

    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("path_route", r -> r.path("/providerService/pay/get/")
                .uri(provideServiceUrl + "/pay/get/*")).build();
    }*/
}
