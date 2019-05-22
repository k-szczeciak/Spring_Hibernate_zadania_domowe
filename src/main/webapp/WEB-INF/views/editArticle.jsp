<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Article</title>
</head>
<body>

<form:form method="post" modelAttribute="article">
    Tytuł:
    <form:input path="title" /><br>
    <input type="submit" value="Aktualizuj" />
</form:form>
</body>
</html>
