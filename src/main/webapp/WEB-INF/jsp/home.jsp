<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/bulma.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
</head>
<body class="container mt-6">
<div class="box">
    <aside class="menu">
        <h1 class="menu-label mb-4">
            <span class="title is-1 ">
                Hello ${user}!
            </span>
        </h1>
        <ul class="menu-list">
            <li>
                <a class="is-active max-w-max has-background-primary">Account Management</a>
                <ul>
                    <li>
                        <a href="/bank_app/users">View Users</a>
                    </li>
                    <li>
                        <a href="/bank_app/transaction">Transaction</a>
                    </li>
                </ul>
            </li>
            <c:if test = "${user == 'Guest'}">
                <li>
                    <a class="is-active max-w-max is-light has-background-info">Sign In Or Sign Up</a>
                    <ul class="row mt-4">
                        <li>
                            <a href="/bank_app/signin" class="button is-info max-w-max">Sign In</a>
                        </li>
                        <li>
                            <a href="/bank_app/signup" class="button  has-background-info-light max-w-max" >Sign Up</a>
                        </li>
                    </ul>
                </li>
            </c:if>
            <c:if test = "${user != 'Guest'}">
                <li class="mt-4">
                    <a class="button is-danger max-w-max" href="/bank_app/signout">Sign Out</a>
                </li>
            </c:if>
        </ul>
    </aside>

</div>
</body>
</html>
