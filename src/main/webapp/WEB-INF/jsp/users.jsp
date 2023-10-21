<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link href="<c:url value="/resources/css/bulma.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
</head>
<body class="container mt-6">
<div class="box">
    <h1 class="menu-label mb-4">
        <span class="title is-1 ">
            ${title}
        </span>
    </h1>
    <table class="table is-striped is-hoverable is-fullwidth ">
       <thead class="has-background-primary-light">
           <tr>
             <th>ID</th>
             <th></th>
             <th>Name</th>
             <th>Email</th>
             <th>Password</th>
             <th>Account Number</th>
             <th>Balance</th>
           </tr>
       </thead>
       <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
               <td>
                    <c:out value="${user.getId()}"/>
               <td>
               <td>
                    <c:out value="${user.getName()}"/>
               </td>
               <td>
                    <c:out value="${user.getEmail()}"/>
               </td>
               <td>
                    <c:out value="${user.getPassword()}"/>
               </td>
               <td>
                    <c:out value="${user.getAccountNumber()}"/>
               </td>
               <td>
                    <c:out value="${user.getBalance()}"/>
               </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="button has-background-primary-light max-w-max" href="/bank_app/">Back</a>
</div>
</body>
</html>
