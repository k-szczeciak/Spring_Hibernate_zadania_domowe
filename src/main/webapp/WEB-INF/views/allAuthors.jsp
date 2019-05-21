<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All Authors</title>
</head>
<body>


<h3>Lista wszystkich autorów: </h3>

<c:forEach items="${authors}" var="author" varStatus="theCount">
    Author Id: ${author.id}, Imię: ${author.firstName}, Nazwisko: ${author.lastName} <a href="removeAuthor/${author.id}">Usuń</a> <a href="editAuthor/${author.id}">Edytuj</a> <br>
</c:forEach>

</body>
</html>
