package com.example.fruehling.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiPrefixConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // Controllers of com.example.fruehling.controllers.pc => /api/pc/...
        configurer.addPathPrefix("/api/pc",
                handlerType -> handlerType.getPackageName()
                        .startsWith("com.example.fruehling.controllers.pc"));

        // Controllers of com.example.fruehling.controllers.user => /api/user/...
        configurer.addPathPrefix("/api/user",
                handlerType -> handlerType.getPackageName()
                        .startsWith("com.example.fruehling.controllers.user"));

    }

}
