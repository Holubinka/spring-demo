<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 27.04.2019
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<h3>Category name: <c:out value="${category.categoryName}"/></h3>
<p>Description: <c:out value="${category.categoryDescription}"/></p>
<c:forEach items="${category.products}" var="p">
    <p><%--<a href="<c:url value="/product?p_id=${p.id}"/>">--%><c:out value="${p.productsName}"/></p>
    <p><%--<a href="<c:url value="/product?p_id=${p.id}"/>">--%><c:out value="${p.price}"/></p>
    <hr/>
    <br/>
</c:forEach>

<h2><a href="<c:url value="/reduce?c_id=${category.id}"/>">Reduce</a> 10% price</h2>

</body>
</html>
