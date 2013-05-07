<%--
  Created by IntelliJ IDEA.
  User: javalons
  Date: 07/05/13
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Orders</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
</head>
<body>
    <%@include file="header.jsp" %>
    <c:set var="hello" value="This is orders page!"/>
    <p/>
    <c:out value="${hello}"/>
    <p/>

    <form method="POST" id="cancelOrder" action="myorders">
        <table>
            <c:forEach var="item" items="${list}" varStatus="index">
                <tr id="order_${item.id}"><td>${item.type}</td><td>${item.price}</td><td>${item.description}</td><td><input type="button" value="Cancel" id="${item.id}" class="postbutton"/></td></tr>
            </c:forEach>
        </table>
    </form>

    <script>
        $('input.postbutton').click( function () {
            var buttonvalue = $(this).attr('id');
            $.ajax({
                type: 'post',
                url: 'myorders',
                data: {'buttonvalue' : buttonvalue},
                success: function (data) {
                    $('#order_'+buttonvalue).hide();
                }

            });

            return false;
        });

    </script>
</body>
</html>