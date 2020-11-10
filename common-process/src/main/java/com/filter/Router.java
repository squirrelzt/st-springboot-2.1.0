package com.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@Slf4j
public class Router implements Filter {
    @Value("${remote.ip}")
    private String ip;
    @Value("${remote.port}")
    private String port;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(httpServletRequest){
            @Override
            public StringBuffer getRequestURL() {
                String url = super.getRequestURL().toString();
                String localAddr = super.getLocalAddr();
                int serverPort = super.getServerPort();
                url = url.replace(localAddr, ip).replace(String.valueOf(serverPort), String.valueOf(port));
                return new StringBuffer(url);
            }
        };
        filterChain.doFilter(requestWrapper, servletResponse);
    }
}
