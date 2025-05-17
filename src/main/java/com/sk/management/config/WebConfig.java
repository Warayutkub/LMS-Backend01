package com.sk.management.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // อนุญาตให้ทุก endpoint
                .allowedOrigins("http://localhost:3000")  // URL ของ Frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}