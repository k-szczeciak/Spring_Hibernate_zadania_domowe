<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>add Category</title>
</head>
<body>
<h3>Dodawanie kategorii</h3>

<form:form method="post" modelAttribute="category">
    Name:
    <form:input path="name" /><br>
    <form:errors path="name"/>
    Description:
    <form:input path="descriprion" /><br>
    <form:errors path="descriprion"/>
    <input type="submit" value="Dodaj" />
</form:form>

</body>
</html>
