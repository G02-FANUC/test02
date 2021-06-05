<%--
  Created by IntelliJ IDEA.
  User: 17639
  Date: 2021/6/2
  Time: 11:25:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" width="80%">
    <tr>
        <td>id</td>
        <td>userName</td>
        <td>sex</td>
        <td>date</td>
        <td>address</td>
        <td>操作</td>
    </tr>
    <%--sbqSbq 是我在   req.setAttribute("sbq",list);--%>

    <c:forEach var="li" items="${list}">
        <tr>
            <td> ${li.id} </td>
            <td> ${li.userName} </td>
            <td> ${li.sex} </td>
            <td> ${li.date} </td>
            <td> ${li.address} </td>
            <td>操作</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
