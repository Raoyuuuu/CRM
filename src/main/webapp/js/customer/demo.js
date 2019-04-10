$(function () {
    //初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $("#table").bootstrapTable({
            url: 'customer_findAll.action',//请求后台的URL（*）
            method: 'post',//请求方式（*）
            toolbar: '#toolbar',//工具按钮用哪个容器
            striped: true,//是否显示行间隔色
            cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,//是否显示分页（*）
            sortable: false,//是否启用排序
            sortOrder: "asc",//排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,//初始化加载第一页，默认第一页
            pageSize: 3,//每页的记录行数（*）
            pageList: [3, 5, 10, 50],//可供选择的每页的行数（*）
            search: false,//是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            contentType: "application/json;charset=utf-8",
            strictSearch: false,
            showColumns:false,//内容列下拉框
            showRefresh: false,//是否显示刷新按钮
            minimumCountColumns: 2,//最少允许的列数
            clickToSelect: true,//是否启用点击选中行
            height: 600,//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "cust_id",//每一行的唯一标识，一般为主键列
            showToggle: false,//是否显示详细视图和列表视图的切换按钮
            cardView: false,//是否显示详细视图
            detailView: false,//是否显示父子表

            responseHandler:responseHandler,
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
            ],

        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        return {//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
           // limit: params.limit,//页面大小
            "pageNumber" : params.pageNumber,
            "pageSize" : params.pageSize
           // offset: params.offset
        };

    };
    return oTableInit;
};


function operateFormatter(value, row, index) {//赋予的参数
    return [
        '<button  class="btn btn-primary btn-sm" onclick="edit(' + row.cust_id + ')">编辑</button>|',
        '<button  class="btn btn-danger btn-sm" onclick="del(' + row.cust_id + ')">删除</button>',
    ].join('');
}

function responseHandler(res){
    return res
}

function edit(id) {
        alert("编辑：" + id);//弹出编辑窗体...用ajax...更新(略)...
    }
function del(id) {
    confirm("删除：" + id);//用ajax...删除(略)...
}

