<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Document</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/bootstrap-theme.css">
    <link rel="stylesheet" href="../../css/bootstrap-table.css">
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/bootstrap-table.js"></script>
    <script src="../../js/bootstrap-table-zh-CN.js"></script>
    <script src="../../js/customer/list.js"></script>
</head>
<style>
    .modal-backdrop {
        filter: alpha(opacity=0)!important;
        opacity: 0!important;
    }
</style>
<body>

<div class="col-md-12">
    <!-- 客户添加 -->
    <div class="pull-right" style="margin-bottom: 5px">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-backdrop="static">新增</button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="0" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document" style="width:400px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">客户添加</h4>
                    </div>
                    <div class="modal-body" style="height: 400px;overflow-y: scroll">
                        <form id="customerAdd" action="${pageContext.request.contextPath}/customer_save.action" method="post">
                            <div class="form-group">
                                <input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
                                <label for="cust_name"  class="control-label">客户名称:</label>
                                <input type="text" class="form-control" id="cust_name" name="cust_name"  >
                                <br>
                                <label for="cust_level"  class="control-label ">客户级别:</label>
                                <select class="form-control" id="cust_level" name="baseDictLevel.dict_id" >
                                    <option value="">请选择</option>
                                </select>
                                <br>
                                <label for="cust_industry"  class="control-label ">所属行业:</label>
                                <select class="form-control" id="cust_industry" name="baseDictIndustry.dict_id" >
                                    <option value="">请选择</option>
                                </select>
                                <br>
                                <label for="cust_source"  class="control-label ">信息来源:</label>
                                <select class="form-control" id="cust_source" name="baseDictSource.dict_id" >
                                    <option value="">请选择</option>
                                </select>
                                <br>
                                <label for="cust_phone"  class="control-label ">移动电话:</label>
                                <input type="text" class="form-control" id="cust_phone" name="cust_phone" >
                                <br>
                                <label for="cust_email"  class="control-label ">邮箱:</label>
                                <input type="email" class="form-control" id="cust_email" name="cust_email" >
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="add_info()">保存</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- 客户列表显示 -->

        <table id="table"></table>



</div>
</body>
</html>
