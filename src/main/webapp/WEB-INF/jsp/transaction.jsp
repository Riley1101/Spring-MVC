<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/bulma.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body class="container mt-6">
<div class="box">
    <h1 class="title is-1">
            Transactions
    </h1>
   <form:form action="transaction" method="post" modelAttribute="transaction">
    <div class="field">
      <label for="email" class="label">Email</label>
      <div class="control has-icons-left has-icons-right">
       <form:input path="email" id="email" class="input is-success is-normal" placeholder="Enter Email"  />
          <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
          </span>
          <span class="icon is-small is-right">
            <i class="fas fa-exclamation-triangle"></i>
          </span>
      </div>
    </div>

    <div class="field">
      <label for="password" class="label">Password</label>
      <div class="control has-icons-left has-icons-right">
       <form:input path="password" id="password" type="password" class="input is-success is-normal" placeholder="Enter Password"  required="true"/>
          <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
          </span>
          <span class="icon is-small is-right">
            <i class="fas fa-exclamation-triangle"></i>
          </span>
      </div>
    </div>

    <div class="field">
          <label for="amount" class="label">Enter Amount</label>
          <div class="control has-icons-left has-icons-right">
           <form:input path="amount" id="amount" type="number" class="input is-success is-normal"
           placeholder="Enter Amount"  required="true"/>
              <span class="icon is-small is-left">
                <i class="fas fa-dollar-sign"></i>
              </span>
              <span class="icon is-small is-right">
                <i class="fas fa-exclamation-triangle"></i>
              </span>
           </div>
    </div>
       <p class="mb-2">Transaction Type</p>
       <label for="credit" class="radio">Credit
            <form:radiobutton path="type" value="credit" id="credit"/>
       </label>
       <label for="debit" class="radio">Debit
            <form:radiobutton path="type" value="debit" id="debit"/>
       </label>
       <br>
       <div class="row mt-4">
           <a class="button has-background-info-light max-w-max" href="/bank_app/">Back</a>
           <input class="button is-primary max-w-max" type="submit" value="Save" />
       </div>
   </form:form>
</div>
</body>
</html>
