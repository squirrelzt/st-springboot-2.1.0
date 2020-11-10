package com.filter;

import lombok.extern.slf4j.Slf4j;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Proxy {

    @Bean
    public ServletRegistrationBean proxyBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new ProxyServlet(), "/api/*");
        bean.addInitParameter("targetUri", "http://127.0.0.1:8080/");
        bean.addInitParameter(ProxyServlet.P_LOG, "true");
        return bean;
    }
}
