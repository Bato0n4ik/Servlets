package org.andreev.sockets.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*System.out.println(req.getHeader("user-agent"));
        Enumeration<String> headers = req.getHeaderNames();
        while(headers.hasMoreElements()){
            String header = headers.nextElement();
            System.out.println(req.getHeader(header));
        }*/
        var param = req.getParameter("param");
        Map<String, String[]> elems = req.getParameterMap();

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setHeader("token", "777" );
        try(PrintWriter writer = resp.getWriter()){
           writer.print("<h2>Hello from FirstServlet</h2>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*var parameters = req.getParameterMap();
        System.out.println(parameters);*/

        try(BufferedReader reader = req.getReader();
            Stream<String> lines = reader.lines()){
            lines.forEach(System.out::println);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
