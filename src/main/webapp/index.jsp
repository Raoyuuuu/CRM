<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java"  contentType="text/html;charset=UTF-8"  %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Document</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/index.css">
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>

</head>
<body>
       <!--顶部导航栏--->
       <nav class="navbar navbar-default navbar-static-top">
           <div class="container-fluid">
               <div class="navbar-header">
                   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                       <span class="sr-only">Toggle navigation</span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                       <span class="icon-bar"></span>
                   </button>
                   <a class="navbar-brand" href="#">CRM管理系统</a>
               </div>
               <ul class="nav navbar-nav navbar-right">
                   <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;当前用户：<s:property value="#session.existUser.user_name" /></a></li>
                   <li><a href="#"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
               </ul>
           </div>
       </nav>

       <!--中间主体部分-->

           <!-- 左侧导航栏 -->
           <div class="navbar-default navbar-collapse">
               <ul class="nav">
                   <li role="presentation">
                       <a href="nav1.html" target="mainFrame" >导航链接1</a>
                   </li>
                   <li role="presentation">
                       <a href="nav2.html" target="mainFrame">导航链接2</a>
                   </li>
                   <li role="presentation">
                       <a href="nav3.html" target="mainFrame">导航链接3</a>
                   </li>
                   <li class="dropdown">
                       <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                           导航链接4<span class="caret"></span>
                       </a>
                       <ul class="dropdown-menu">
                           <li>
                               <a href="nav1.html" target="mainFrame">导航链接4-1</a>
                           </li>
                           <li>
                               <a href="nav2.html" target="mainFrame">导航链接4-2</a>
                           </li>
                           <li>
                               <a href="nav3.html" target="mainFrame">导航链接4-3</a>
                           </li>
                       </ul>
                   </li>
                   <li role="presentation">
                       <a href="nav4.html" target="mainFrame">导航链接5</a>
                   </li>
               </ul>

           </div>


</body>
</html>
