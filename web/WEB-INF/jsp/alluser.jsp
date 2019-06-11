<%--
  Created by IntelliJ IDEA.
  User: 苏航
  Date: 2019/5/21
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${users}" var="item">

        <tr>
            <td>${item.id}</td>
            <c:choose>
                <c:when test="${item.name=='suhang'}">
                    <td>ok</td></c:when>
                <c:when test="${item.name=='苏航'}"><td>ok</td></c:when>
            </c:choose>
            <td>${item.password}</td>
        </tr>
    </c:forEach>
</body>
</html>
