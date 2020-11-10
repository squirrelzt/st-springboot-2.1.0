package com.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("my filter start ......");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("my filter end --------------");
    }

    @Override
    public void destroy() {

    }
}
