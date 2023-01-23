<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>
<body>
    <h2>Купленный билеты<h2>
    <c:if test="${ not empty requestScope.tickets}">
        <ul>
            <c:forEach var="ticket" items= "${requestScope.tickets}">
                <li>${f:toLowerCase(ticket.getSeatNo())}</li>
            </c:forEach>
        </ul>
    </c:if>

</body>
</html>

