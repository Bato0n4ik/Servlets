package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.andreev.sockets.service.UserDto;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    private final static String USER = "user";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var attribute = (UserDto) session.getAttribute(USER);
        if(attribute == null){
            session.setAttribute(USER, UserDto.builder()
                    .id(1L)
                    .mail( "piss_0f_sheet@gmail.com")
                    .build()
            );
        }
    }
}
