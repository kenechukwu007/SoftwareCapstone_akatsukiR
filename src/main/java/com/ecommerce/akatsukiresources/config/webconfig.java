package com.ecommerce.akatsukiresources.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public  class webconfig  implements WebMvcConfigurer {


    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/**") .allowedMethods("") .allowedOrigins("") .allowedHeaders("*") .allowCredentials(false) .maxAge(86400);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }

}