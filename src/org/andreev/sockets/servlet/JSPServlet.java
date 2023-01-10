package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.andreev.sockets.service.FlightDto;
import org.andreev.sockets.service.FlightService;
import org.andreev.sockets.util.JSPUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet("/content")
public class JSPServlet extends HttpServlet {

    private static final FlightService flightsService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        var flightsDto = flightsService.findAll();
        req.setAttribute("flights", flightsDto);
        req.setAttribute("flightMap", flightsDto.stream().collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));



        req.getRequestDispatcher(JSPUtil.getJspFilesPath("content")).include(req, resp);


    }
}
