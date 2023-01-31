package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.andreev.sockets.service.UserDto;
import org.andreev.sockets.service.UserService;
import org.andreev.sockets.util.JSPUtil;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSPUtil.getJspFilesPath("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.getUserDto(req.getParameter("email"), req.getParameter("password")).ifPresentOrElse(
                user -> onLoginSuccess(req, resp, user),
                () -> onLoginFail(req, resp)
        );
    }

    @SneakyThrows
    private void onLoginSuccess(HttpServletRequest req, HttpServletResponse resp, UserDto user){
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/flights");
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp){
        resp.sendRedirect("/login?error=fail&email=" + req.getParameter("email"));
    }
}
