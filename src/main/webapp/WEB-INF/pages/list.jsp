<%--
  Created by IntelliJ IDEA.
  User: javalons
  Date: 17/04/13
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>List</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
</head>
<body>
    <%@include file="header.jsp" %>
    <c:set var="hello" value="This is list page!"/>
    <p/>
    <c:out value="${hello}"/>
    <p/>

    <form:form method="POST" id="addOrder" action="list">
        <c:forEach var="item" items="${list}" varStatus="index">
            <div>${index.index}: ${item.type} ** ${item.price} ** ${item.description} <input type="submit" value="Order" id="${index.index}"/> </div>
        </c:forEach>
    </form:form>
</body>
</html>