package org.andreev.sockets.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static org.andreev.sockets.util.UtilPath.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    private final Set<String> PUBLIC_PATHS = Set.of(REGISTRATION, LOGIN, IMAGE);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var requestUri = (String)((HttpServletRequest)servletRequest).getRequestURI();

        if(isPublicPath(requestUri) || isUserSignIn(servletRequest)){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            var prevPageUri = ((HttpServletRequest)servletRequest).getHeader("referer");
            ((HttpServletResponse)servletResponse).sendRedirect(prevPageUri != null ? prevPageUri: LOGIN);
        }
    }

    private boolean isUserSignIn(ServletRequest servletRequest) {
        return ((HttpServletRequest)servletRequest).getSession().getAttribute("user") != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATHS.stream().anyMatch(item -> uri.startsWith(item));
    }
}
