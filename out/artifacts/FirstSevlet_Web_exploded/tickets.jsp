<%@ page import="org.andreev.sockets.service.TicketService" %>
<%@ page import="org.andreev.sockets.service.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintStream" %><%--
  Created by IntelliJ IDEA.
  User: Bato0n4ik
  Date: 08.01.2023
  Time: 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <h1>Hello world!<h1>
        <ul>
            <%
                Long flightId = Long.valueOf(request.getParameter("flightId"));
                List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
                for(TicketDto ticket: tickets){
                    out.write(String.format("<li> %s </li>", ticket.getSeatNo()));
                }
            %>
        </ul>

</body>
</html>
<%!
    public void jspInit(){
        System.out.println("Hello man, what's up");
    }
    %>
