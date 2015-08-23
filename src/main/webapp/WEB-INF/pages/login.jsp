<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Login to ORDRD</title>

<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

</head>

<body>
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3 form-box">
        <div class="form-top">
          <div class="form-top-left">
            <h3>Login to our site</h3>
            <p>Enter your Username and Password to log on:</p>
          </div>
          <div class="form-top-right glyphicon glyphicon-lock"></div>
        </div>

        <div class="form-message">
          <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
              <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> Incorrect Username or Password.
            </div>
          </c:if>
          <c:if test="${not empty logout}">
            <div class="alert alert-success" role="alert">
              <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> You have been logged out successfully.
            </div>
          </c:if>
        </div>

        <div class="form-bottom">
          <form role="form" action="" method="POST" class="login-form" name="">
            <div class="form-group">
              <label class="sr-only" for="form-username">Username</label>
              <input type="text" name="username" placeholder="Username..." class="form-control" id="form-username">
            </div>
            <div class="form-group">
              <label class="sr-only" for="form-password">Password</label>
              <input type="password" name="password" placeholder="Password..." class="form-control" id="form-password">
            </div>
            <div class="form-group">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </div>
            <button type="submit" class="btn btn-outline-inverse">Log in</button>
          </form>
          <div class="form-group">
            Do not have any account? <a href="register">create new account</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Javascript -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="assets/js/scripts.js"></script>
</body>
</html>