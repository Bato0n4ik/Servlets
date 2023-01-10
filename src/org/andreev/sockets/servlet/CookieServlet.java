package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {

    private static final String UNIQ_ID = "user_id";
    private static final AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies = req.getCookies();

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        if(cookies == null || Arrays.stream(cookies)
                .filter(cookie -> UNIQ_ID.equals(cookie.getName()))
                .findFirst()
                .isEmpty()
        ){
            var customCookie = new Cookie(UNIQ_ID, "1");
            customCookie.setPath("/cookies");
            customCookie.setMaxAge(15*60);

            try(var writeStream = resp.getWriter()){
                writeStream.write(counter.addAndGet(1));
            }
        }
    }
}
