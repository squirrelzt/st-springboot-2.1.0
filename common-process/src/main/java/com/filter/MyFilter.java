package com.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class MyFilter implements Filter {

    private final String myPort;

    public MyFilter(String myPort) {
        this.myPort = myPort;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("my filter start ......");
        log.info("-------myPort---------");
        log.info("myPort={}", myPort);
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("my filter end --------------");
    }

    @Override
    public void destroy() {

    }
}
