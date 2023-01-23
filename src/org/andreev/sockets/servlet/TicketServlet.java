package org.andreev.sockets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.andreev.sockets.service.TicketService;
import org.andreev.sockets.util.JSPUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        var flightId =  Long.valueOf(req.getParameter("flightId"));
        req.setAttribute("tickets", ticketService.findAllByFlightId(flightId));

        req.getRequestDispatcher(JSPUtil.getJspFilesPath("tickets")).include(req,resp);


        /*
        try(var streamWriter = resp.getWriter()){
            streamWriter.write("<h2>Купленный билеты<h2>");

            streamWriter.write("<ul>");

            ticketService.findAllByFlightId(flightId).forEach(ticketDto -> {
                streamWriter.write(
                        """
                        <li> %s </li>
                        """.formatted(ticketDto.getSeatNo()));
            });
            streamWriter.write("</ul>");
        }
        catch(Exception exc){
            exc.printStackTrace();
        }*/
    }
}
