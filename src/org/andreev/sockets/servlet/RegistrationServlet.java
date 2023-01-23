package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.andreev.sockets.entity.Gender;
import org.andreev.sockets.entity.Role;
import org.andreev.sockets.exceptions.ValidationException;
import org.andreev.sockets.service.CreateUserDto;
import org.andreev.sockets.service.UserService;
import org.andreev.sockets.util.JSPUtil;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());
        req.getRequestDispatcher(JSPUtil.getJspFilesPath("registration")).include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userDto = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .birthday(req.getParameter("birthday"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .image(req.getPart("image"))
                .build();
        try{
            userService.getUserDao(userDto);
            resp.sendRedirect("/login");
        }
        catch(ValidationException exc){
            req.setAttribute("errors", exc.getErrors());
            doGet(req,resp);

        }


    }
}
