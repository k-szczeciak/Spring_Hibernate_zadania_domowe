<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>edit category</title>
</head>
<body>

<form:form method="post" modelAttribute="category">
    Name:
    <form:input path="name" /><br>
    Description:
    <form:input path="descriprion" /><br>
    <input type="submit" value="Aktualizuj" />
</form:form>

</body>
</html>
