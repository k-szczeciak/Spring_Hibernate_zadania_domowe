<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 21/05/2019
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All Articles</title>
</head>
<body>

<h3>Lista wszystkich artykułów: </h3>

<c:forEach items="${articles}" var="article" varStatus="theCount">
    Author Id: ${article.id}, Imię: ${article.title}, Autor: ${article.author.firstName} <a href="removeArticle/${article.id}">Usuń</a> <a href="editArticle/${article.id}">Edytuj</a> <br>
</c:forEach>

</body>
</html>
