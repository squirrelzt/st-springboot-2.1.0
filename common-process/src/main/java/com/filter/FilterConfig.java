package com.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FilterConfig {

    @Value("${myFilter.port}")
    private String myPort;

    @Bean
    public FilterRegistrationBean<MyFilter> registerMyFilter() {
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter(myPort));
        bean.addUrlPatterns("/*");
        bean.setName("myFilter");
        bean.setOrder(1);
        return bean;
    }
}
