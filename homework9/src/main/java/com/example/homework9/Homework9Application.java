package com.example.homework9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Homework9Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework9Application.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("ListTasks",r->r.path("/serviceA/**")
						.uri("http://localhost:8081/"))
				.route("ListWorkers",r->r.path("/serviceB/**")
						.uri("http://localhost:8082/")).build();}
}
