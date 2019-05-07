<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 07.05.2019
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h3>Product name: <c:out value="${product.productsName}"/></h3>
<p>Product Description: <c:out value="${product.productsDescription}"/></p>
<p>Product Price: <c:out value="${product.price}"/></p>

<h2><a href="<c:url value="/reduce?p_id=${product.id}"/>">Reduce</a> 10% price</h2>

</body>
</html>
