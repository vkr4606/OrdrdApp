<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register to ORDRD</title>

<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
  <form class="form-horizontal" method="POST" action="register">
    <fieldset>
      <!-- Form Name -->
      <legend>Registration Form</legend>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label" for="firstName">First Name</label>
        <div class="col-md-4">
          <input id="firstName" name="firstName" type="text" class="form-control input-md" required>
        </div>
      </div>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label" for="lastName">Last Name</label>
        <div class="col-md-4">
          <input id="lastName" name="lastName" type="text" class="form-control input-md">
        </div>
      </div>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label" for="emailId">Email Id</label>
        <div class="col-md-4">
          <input id="emailId" name="emailId" type="text" class="form-control input-md" required>
        </div>
      </div>

      <div class="form-group">
        <label class="col-md-4 control-label" for="contactNo">Contact No</label>
        <div class="col-md-4">
          <div class="input-group">
            <span class="input-group-addon">+91</span>
            <input id="contactNo" name="contactNo" class="form-control" type="text" required>
          </div>
        </div>
      </div>

      <div class="form-group">
        <label class="col-md-4 control-label" for="password">New Password</label>
        <div class="col-md-4">
          <input id="new-password" name="password" type="password" class="form-control input-md" required>
        </div>
      </div>

      <div class="form-group">
        <label class="col-md-4 control-label" for="confirm-password">Confirm Password</label>
        <div class="col-md-4">
          <input id="confirm-password" name="confirm-password" type="password" class="form-control input-md" required>
        </div>
      </div>

      <!-- Button (Double) -->
      <div class="form-group">
        <label class="col-md-4 control-label" for="save"></label>
        <div class="col-md-4">
          <button type="submit" id="save" name="save" class="btn btn-outline-inverse">Save</button>
          <button type="reset" id="reset" name="reset" class="btn btn-default">Reset</button>
        </div>
      </div>

      <div class="form-group">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </div>

    </fieldset>
  </form>
  <div class="form-group">
    Have an existing account? <a href="login">log in</a>
  </div>

  <!-- Javascript -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>