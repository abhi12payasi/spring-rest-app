package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@PropertySource("classpath:app.properties")
@EnableWebMvc
@ComponentScan(basePackages = "com.app")
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    public InternalResourceViewResolver ivr(){
        InternalResourceViewResolver i = new InternalResourceViewResolver();
        i.setSuffix(environment.getProperty("spring.mvc.prefix"));
        i.setPrefix(environment.getProperty("spring.mvc.suffix"));
        return i;
    }
}
