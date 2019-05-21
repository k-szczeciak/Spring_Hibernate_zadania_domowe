<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    Imię:
    <form:input path="firstName" /><br>
    Nazwisko:
    <form:input path="lastName" /><br>
    <input type="submit" value="Aktualizuj" />
</form:form>

</body>
</html>
