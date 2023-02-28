package org.andreev.sockets.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
@WebFilter(
        servletNames = {
                "RegistrationServlet"
        },
        initParams = {
                @WebInitParam(name = "keyOne", value = "valueOne")
        },
        dispatcherTypes = DispatcherType.ERROR
)*/
public class CharsetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        var paramNames = filterConfig.getInitParameterNames();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(StandardCharsets.UTF_8.name());
        servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
