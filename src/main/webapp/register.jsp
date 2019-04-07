<%@ page language="java"  contentType="text/html;charset=UTF-8"  %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Document</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/register.css">
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>

</head>
<body>
<main class="main" role="main">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">

                <form class="form-container" action="${pageContext.request.contextPath}/user_register.action" method="post">
                    <h2>用户注册</h2>
                    <div class="form-group">
                        <label>用户账号</label>
                        <input type="text" class="form-control" name="user_code" autocomplete="new-text" aria-describedby="emailHelp" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label>用户姓名</label>
                        <input type="text" class="form-control" name="user_name" autocomplete="new-text" placeholder="请输入真实姓名">
                    </div>
                    <div class="form-group">
                        <label>登录密码</label>
                        <input type="password" class="form-control" name="user_password" autocomplete="new-password" placeholder="请输入密码">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">提交</button>
                </form>
            </div>
        </div>

    </div>
</main>

</body>
</html>
