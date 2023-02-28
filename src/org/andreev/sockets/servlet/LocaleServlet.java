package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.andreev.sockets.util.UtilPath.LOGIN;

@WebServlet("/locale")
public class LocaleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locale = req.getParameter("lang");
        req.getSession().setAttribute("lang", locale);

        var prevPage = req.getHeader("referer");
        var page = prevPage != null? prevPage: LOGIN;

        Pattern regex = Pattern.compile("\\?(lang=.+(\\?)?)+$");
        Matcher matcher = regex.matcher(page);
        if(matcher.find()){
            String replaceSubString = page.substring(matcher.start(), matcher.end());
            page = page.replace(replaceSubString, "");
        }

        resp.sendRedirect(page + "?lang=" + locale);
    }
}
