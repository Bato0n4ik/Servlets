<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<%@ include file="header.jsp"%>

<h1>   Registration Form   </h1>

<img height="260" width="200" src="${pageContext.request.contextPath}/imagesForFirstServlet/users/699116353.jpg" alt="User image">

<form action="/registration" method="post" enctype="multipart/form-data">
    <label for="name"><fmt:message key="page.registration.name"/>:
        <input type="text" name="name" id="name">
    </label><br>

    <label for="birthday"><fmt:message key="page.registration.birthday"/>:
        <input type="date" name="birthday" id="birthday">
    </label><br>

    <label for="imageId"><fmt:message key="page.registration.image"/>:
        <input type="file" name="image" id="imageId" required>
    </label><br>

    <label for="email"><fmt:message key="page.login.email"/>:
        <input type="text" name="email" id="email">
    </label><br>

    <label for="password"><fmt:message key="page.login.password"/>:
        <input type="password" name="password" id="password">
    </label><br>

    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value=${role}>${role}</option>
        </c:forEach>
    </select><br>

    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value = "${gender}">${gender}
    </c:forEach>
    <br>
    <button type="submit"><fmt:message key="page.login.submit.button"/></button>

    <c:if test="${ not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>
</form>

</body>
</html>
