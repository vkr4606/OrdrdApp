<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
  <h1>Title : ${title}</h1>
  <h1>Message : ${message}</h1>
  <c:url var="logoutUrl" value="/logout" />
  <form action="${logoutUrl}" method="post">
    <button type="submit" class="btn btn-outline-inverse">Log out</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="assets/js/scripts.js"></script>
</body>
</html>