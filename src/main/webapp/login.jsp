
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="../../favicon.ico">

    <title>登录页面</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="./css/signin.css" rel="stylesheet">
    <script src="./assets/js/ie8-responsive-file-warning.js"></script>
    <script src="./assets/js/ie-emulation-modes-warning.js"></script>
</head>
<style>
    .login h2{
          text-align: center;
    }
</style>

<body>

<div class="container">
<div class="login">
    <form class="form-signin" action="${pageContext.request.contextPath}/user_login.action" method="post">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="user_code" class="sr-only">用户名</label>
        <input type="text" id="user_code" name="user_code" class="form-control" autocomplete="new-text"  placeholder="UserName" required autofocus>
        <label for="user_password" class="sr-only">密码</label>
        <input type="password" id="user_password" name="user_password" class="form-control" autocomplete="new-password"  placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</div>


<script src="./assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

