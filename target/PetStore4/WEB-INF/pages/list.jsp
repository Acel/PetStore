<%--
  Created by IntelliJ IDEA.
  User: javalons
  Date: 17/04/13
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
</head>
<body>
    <c:set var="hello" value="This is list page!"/>
    <p/>
    <c:out value="${hello}"/>
    <p/>

    <c:forEach var="item" items="${list}" varStatus="index">
        <div>${index.index}: ${item.type} - ${item.price} - ${item.description}</div>
    </c:forEach>
</body>
</html>