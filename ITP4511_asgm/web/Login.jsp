<%-- 
    Document   : Login
    Created on : 2023年4月21日, 上午02:32:57
    Author     : qwer1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='css/kiratem2.css' rel='stylesheet'>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
        <title>JSP Page</title>
    </head>
    <body>
          <div class="register-photo">
    <div class="form-container">
      <div class="image-holder"></div>
      <form id='LoginForm'>
        <h2 class="text-center"><strong>Welcome Back!</strong></h2>
        <div class="form-group mb-2"><input class="form-control" id="username" type="text" name="username"
            placeholder="Username" value="" required=""></div>
        <div class="form-group mb-2"><input class="form-control" id="password" type="password" name="password"
            placeholder="Password" value="" required=""></div>
        <div class="form-group mt-2">
          <div class="d-flex justify-content-between">
            <div class="form-check">
              <input class="" type="checkbox" value="" id="flexCheckDefault"> <a> Remember me </a>
            </div>
            <div class="mb-3">
              <a rel="nofollow noopener" href="./CandidateSignup.html" class="text-right">Click Sign up !</a>
            </div>
          </div>
        </div>
        <div class="form-group mb-3">
          <div class="d-flex justify-content-between">
            <div>
            <a>&nbsp</a>
            </div>
            <div>
              <a rel="nofollow noopener" href="./CandidateForgetPassword.html">Forget
                password !</a>
            </div>
          </div>
        </div>
          <div class="form-group">
            <button class="btn btn-success btn-block btn-info" id="Login" type="submit">Login</button>
          </div><a class="already" href="#">Terms of Use and Privacy Policy</a>
      </form>
    </div>
  </div>
    </body>
</html>
