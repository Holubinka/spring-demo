<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 26.04.2019
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome ${user.firstName}!</h1>
<h3>You can visit this page <a class="nav-link" href="<c:url value="/home"/>">Home page</a></h3>
</body>
</html>
