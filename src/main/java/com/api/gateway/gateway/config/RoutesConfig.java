package com.api.gateway.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
    @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route("users-route", r -> r
            .path("/api/users")
            .filters(f -> f.setPath("/users"))
            .uri("https://jsonplaceholder.typicode.com"))
        .route("posts-route", r -> r
            .path("/api/posts")
            .filters(f -> f.setPath("/posts"))
            .uri("https://jsonplaceholder.typicode.com"))
        .build();
  }
    
}
