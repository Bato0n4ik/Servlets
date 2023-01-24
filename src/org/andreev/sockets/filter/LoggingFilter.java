package org.andreev.sockets.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.andreev.sockets.service.CreateUserDto;

import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CreateUserDto user = (CreateUserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        if(user == null){
            ((HttpServletResponse) servletResponse).sendRedirect("/registration");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
