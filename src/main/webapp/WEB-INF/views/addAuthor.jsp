<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>

<h3>Dodawanie Autorów</h3>

<form:form method="post" modelAttribute="author">
    Imię:
    <form:input path="firstName" /><br>
    Nazwisko:
    <form:input path="lastName" /><br>
    <input type="submit" value="Dodaj" />
</form:form>

</body>
</html>
