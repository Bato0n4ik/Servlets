package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());*/

        req.getRequestDispatcher("/flights").include(req, resp);
        //resp.sendRedirect("/flights");
        //req.getRequestDispatcher("/flights").forward(req,resp);
        resp.getWriter().write("<h2> Hello it's string from dispatcher servlet!</h2>");

    }
}
