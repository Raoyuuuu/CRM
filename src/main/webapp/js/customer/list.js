
$(function(){
    var $table = $("#table");

    $table.bootstrapTable({

        url:'customer_findAll.action',
        method:'post',
        contentType: "application/json;charset=utf-8",
        dataType:'json',
        //显示分页工具条
        pagination:true,
        //分页条位置
        pagePosition:"bottom",
        //初始化页数
        pageNumber:1,
        //每页显示多少条记录
        pageSize:3,
        pageList:[3,5,10],
        paginationPreText:'上一页',
        paginationNextText:'下一页',
        //条纹
        striped:true,
        height:400,
        showColumns:false,//内容列下拉框
        showRefresh:false,//刷新按钮
        //服务端分页，还有client，不过不认为除非想玩单机版的，基本都是由服务端进行分页
        sidePagination:"server",
        toolbar:"#toolbar",
        //每一行的唯一标识，一般为主键列
        uniqueId: "cust_id",
        //接受后台传过来的值进行绑定处理的函数
        responseHandler:responseHandler,
        queryParamsType:"",
        /* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
           设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
        queryParams:queryParams,//一系列操作后向后台发送参数的函数
        columns:[
            {
                title: "ID",
                field: "cust_id",
                align:'center',
                valign: "middle"
            },{
                title:"客户名称",
                field:"cust_name",
                align:'center',
                valign:"middle"
            },{
                title:"客户来源",
                field:"baseDictSource.dict_item_name",
                align:'center',
                valign:"middle"
            },{
                title:"客户行业",
                field:"baseDictIndustry.dict_item_name",
                align:'center',
                valign:"middle"
            },{
                title:"客户级别",
                field:"baseDictLevel.dict_item_name",
                align:'center',
                valign:"middle"
            },{
                title:"电话",
                field:"cust_phone",
                align:'center',
                valign:"middle"
            },{
                title:"邮箱",
                field:"cust_email",
                align:'center',
                valign:"middle"
            },
            {
                title:"操作",
                align:'center',
                formatter:operateFormatter //自定义方法，添加操作按钮
            }
        ]
    });

function operateFormatter(value, row, index) {//赋予的参数
    return [
        '<button  class="btn btn-primary btn-sm" onclick="edit(' + row.cust_id + ')">编辑</button>|',
        '<button  class="btn btn-danger btn-sm" onclick="del(' + row.cust_id + ')">删除</button>',
    ].join('');
}

function responseHandler(res){
    return res
}

function queryParams(params){
    //一系列操作后向后台传递的参数，这里可以传搜索框的值
    //var searchName = $("#searchName").val();
    return{
         "pageNumber" : params.pageNumber,
         "pageSize" : params.pageSize
        //"searchName" : searchName
    }
}



    // 页面加载函数就会执行：
    // 页面加载，异步查询字典数据：
    // 加载客户来源
    $.post($("#PageContext").val()+'/baseDict_findByTypeCode.action',{"dict_type_code":"002"},function(data){
        // 遍历json的数据:
        $(data).each(function(i,n){
            $("#cust_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
        });
    },"json");
    $.post($("#PageContext").val()+'/baseDict_findByTypeCode.action',{"dict_type_code":"006"},function(data){
        // 遍历json的数据:
        $(data).each(function(i,n){
            $("#cust_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
        });
    },"json");
    $.post($("#PageContext").val()+'/baseDict_findByTypeCode.action',{"dict_type_code":"001"},function(data){
        // 遍历json的数据:
        $(data).each(function(i,n){
            $("#cust_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
        });
    },"json");


});

function edit(cust_id){
    alert("编辑"+cust_id);
}

function add_info() {
    var form = document.getElementById('customerAdd');
    form.submit();
    window.history.back(-1);

}