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
       <nav class="navbar navbar-inverse navbar-static-top">
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
           <div class="navbar-default navbar-collapse" style="margin-top: -20px" id="navleft">
                <ul class="nav">
                    <li><a href="#sub1" data-toggle="collapse">功能菜单 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                        <ul id="sub1" class="nav collapse">
                            <li><a href="jsp/customer/list.jsp" target="mainFrame">客户管理</a></li>
                            <li><a href="#" target="mainFrame">联系人管理</a></li>
                            <li><a href="#" target="mainFrame">客户拜访管理</a></li>
                        </ul>
                    </li>
                    <li><a href="#">综合查询 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
                    <li><a href="#">统计分析 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
                    <li><a href="#">系统管理 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
                </ul>
           </div>
           <!--面包屑导航-->
           <div class="page-main">
               <ol class="breadcrumb">
                   <span class="glyphicon glyphicon-menu-hamburger"></span>
                   <li><a href="#">Home</a></li>
                   <li><a href="#">Library</a></li>
                   <li class="active">Data</li>
               </ol>
           </div>
           <!--主要-->
       <div class="pageContent">

           <iframe src="jsp/customer/list.jsp" id="mainFrame" name="mainFrame" frameborder="0" width="100%" height="100%" frameBorder="0"></iframe>
       </div>


</body>
</html>
