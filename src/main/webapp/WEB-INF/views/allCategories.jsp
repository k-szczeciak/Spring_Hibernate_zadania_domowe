<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>all categories</title>
</head>
<body>

<h3>Lista wszystkich kategorii: </h3>

<c:forEach items="${categories}" var="category" varStatus="theCount">
    category Id: ${category.id}, nazwa kategori: ${category.name} <a href="removeCategory/${category.id}">Usuń</a> <a href="editCategory/${category.id}">Edytuj</a> <br>
</c:forEach>

</body>
</html>
