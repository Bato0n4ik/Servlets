<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пшёл ты</title>
</head>
<body>

    <div>
        <%@include file="header.jsp"%>
    </div>

    <span>Content. Русский</span>

    <p>Size: ${requestScope.values().size()}</p>
    <p>Id: ${requestScope.flights[0]}</p>
    <p>HashMap id: ${sessionScope.flightMap.get(3).id}</p>
    <p>JSESSION Id: ${cookie["JSESSIONID"].value}</p>
    <p>Header: ${header["cookie"]}</p>
    <p>Param id: ${param.id}</p>
    <p>Param test: ${param.test}</p>

    <div>
        <%@include file="footer.jsp"%>
    </div>

</body>
</html>
