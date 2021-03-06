<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 23.04.2019
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/bootstrap/css/signin.css"/>" rel="stylesheet">
</head>

<body class="text-center">
<spring:form class="form-signin" method="post" modelAttribute="user">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Username</label>
    <spring:input path="username" id="inputEmail" class="form-control" placeholder="Username"/>
    <label for="inputPassword" class="sr-only">Password</label>
    <spring:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <h4 class="h4 mb-4 font-weight-normal">New to this site? <a class="nav-link" href="<c:url value="/register"/>">Register now</a></h4>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</spring:form>
</body>
</html>
