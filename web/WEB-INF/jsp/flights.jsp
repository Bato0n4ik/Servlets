<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Жопа</title>
</head>
<body>

    <h1> Список перелётов</h1>
    <c:if test="${not empty requestScope.flights}">
        <c:forEach var="flight" items="${requestScope.flights}">
            <li>
                <a href="/tickets?flightId=${flight.id}">${flight.description}</a>
            </li>
        </c:forEach>
    </c:if>

</body>
</html>
