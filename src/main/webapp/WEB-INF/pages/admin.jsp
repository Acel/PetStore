<%--
  Created by IntelliJ IDEA.
  User: javalons
  Date: 17/04/13
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Admin</title>
</head>
<body>

    <form:form method = "post" action="admin">
        <table>
            <tbody>
                <tr>
                    <td><form:label path="type">Type</form:label></td>
                    <td><form:input path="type"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="price">Price</form:label></td>
                    <td><form:input path="price"></form:input></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"></form:input></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"></td>
                </tr>
            </tbody>
        </table>
    </form:form>

</body>
</html>