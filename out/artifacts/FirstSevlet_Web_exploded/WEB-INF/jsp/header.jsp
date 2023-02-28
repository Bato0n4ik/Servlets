<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

    <c:if test="${not empty sessionScope.user}">
        <div>
            <form action="${pageContext.request.contextPath}/logout" method ="post">
                <button type="submit"> Logout </button>
            </form>
        </div>
    </c:if>

    <div>
        <form action="${pageContext.request.contextPath}/locale" method="post">
            <button type="submit" name="lang" value="ru_RU">RU</button>
            <button type="submit" name="lang" value="en_US">EN</button>
        </form>
    </div>

    <fmt:setLocale value = "${sessionScope.lang != null? sessionScope.lang: (param.lang != null? param.lang: 'en_US')}"/>
    <fmt:setBundle basename="translations"/>

</html>

