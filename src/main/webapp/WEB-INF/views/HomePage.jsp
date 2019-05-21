<%--
  Created by IntelliJ IDEA.
  User: krzysztofszczeciak
  Date: 18/05/2019
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<h2>Lista ostatnich 5 artykułów</h2>
<br>
<br>
<table border ="1">
    <tr>
        <th>id</th>
        <th>title</th>
        <th>content</th>
        <th>author name</th>
        <th>category</th>
        <th>created</th>
        <th>view</th>
    </tr>

        <c:forEach items="${articles}" var="articles" >
            <tr>
                <td>${articles.id} <br>
                </td>
                <td>${articles.title} <br>
                </td>
                <td>${articles.content} <br>
                </td>
                <td>${articles.author.firstName} <br>
                </td>
                <td>${articles.category.name} <br>
                </td>
                <td>${articles.created} <br>
                </td>
                </td>
                <td><a href="/allArticles/${articles.category.id}" > view category article list </a> <br>
                </td>
            </tr>
        </c:forEach>
</table>
<br><br>

<h3>links:</h3>
<a href="/allCategories" >wszystkie kategorie</a><br>
<a href="/addCategory" >dodaj katgorie</a><br>

</body>
</html>
