<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Document</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
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
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            新增
        </button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="0" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document" style="width:400px">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">客户添加</h4>
                    </div>
                    <div class="modal-body" style="height: 400px;overflow-y: scroll">
                        <form action="#">
                            <div class="form-group">
                                <label  class="control-label">客户名称:</label>
                                <input type="text" class="form-control" name="customer_name"  >
                                <br>
                                <label  class="control-label ">客户级别:</label>
                                <input type="text" class="form-control" name="customer_level" >
                                <br>
                                <label  class="control-label ">所属行业:</label>
                                <input type="text" class="form-control" name="customer_industry" >
                                <br>
                                <label  class="control-label ">信息来源:</label>
                                <input type="text" class="form-control" name="customer_sources" >
                                <br>
                                <label  class="control-label ">移动电话:</label>
                                <input type="text" class="form-control" name="customer_phone" >
                                <br>
                                <label  class="control-label ">邮箱:</label>
                                <input type="email" class="form-control" name="customer_email" >
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">保存</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- 客户列表显示 -->
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>one</th>
            <th>two</th>
            <th>three</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td>sa</td>
        <td>dwe</td>
        <td>sa</td>
        <td>sada</td>
        </tr>
        <tr>
            <td>sa</td>
            <td>dwe</td>
            <td>sa</td>
            <td>sada</td>
        </tr>
        </tbody>

    </table>
    </div>
</div>
</body>
</html>
