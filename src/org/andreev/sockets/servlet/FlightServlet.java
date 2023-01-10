package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.andreev.sockets.service.FlightService;

import java.io.IOException;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private static final FlightService flightService = FlightService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        var writeStream = resp.getWriter();
            writeStream.write("<h1> Список перелётов</h1>");
            writeStream.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
                writeStream.write(
                """
                <li>
                    <a href="/tickets?flightId=%d">%s</a>
                </li>
                """.formatted(flightDto.getId(), flightDto.getDescription()));
            });
            writeStream.write("</ul>");
    }
}
