
$(function(){
    $('#addModal').on('hidden.bs.modal', function() {
        //document.getElementById("addForm").reset();
        //$(this).removeData('bs.modal');
        $(':input','#addForm').not(':button,:submit,:reset').val('').removeAttr('checked').removeAttr('checked');
    });



    var $table = $("#table");

    $table.bootstrapTable({

        url:'customer_findAll.action',
        //method:'post',
        contentType: "application/json;charset=utf-8",
        dataType:'json',
        //显示分页工具条
        pagination:true,
        //分页条位置
        //pagePosition:"bottom",
        //初始化页数
        pageNumber:1,
        //每页显示多少条记录
        pageSize:5,
        pageList:[5,10,50],
        paginationPreText:'上一页',
        paginationNextText:'下一页',
        //条纹
        striped:true,
        //height:380,
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
                visible:false,
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

//onclick="del(' + row.cust_id + ')"
function operateFormatter(value, row, index) {//赋予的参数
    return [
        '<button  class="btn btn-primary"  data-toggle="modal" data-target="#updateModal"  ' +
        'data-backdrop="static" onclick="edit(this)">编辑</button>|',
        '<button  class="btn btn-danger  del"  >删除</button>',
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

    //修改
    $.post($("#PageContextt").val()+'/baseDict_findByTypeCode.action',{"dict_type_code":"002"},function(data){
        // 遍历json的数据:
        $(data).each(function(i,n){
            $("#edit_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
        });
    },"json");
    $.post($("#PageContext").val()+'/baseDict_findByTypeCode.action',{"dict_type_code":"006"},function(data){
        // 遍历json的数据:
        $(data).each(function(i,n){
            $("#edit_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
        });
    },"json");
    $.post($("#PageContext").val()+'/baseDict_findByTypeCode.action',{"dict_type_code":"001"},function(data){
        // 遍历json的数据:
        $(data).each(function(i,n){
            $("#edit_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
        });
    },"json");

});
// async. 默认是 true，即为异步方式，$.ajax执行后，会继续执行ajax后面的脚本，
// 直到服务器端返回数据后，触发$.ajax里的success方法，这时候执行的是两个线程。
// async 设置为 false，则所有的请求均为同步请求，在没有返回值之前，同步请求将锁住浏览器，
// 用户其它操作必须等待请求完成才可以执行。

$(document).on("click",".del",function(){//找到点击的类目为del的按钮实现删除
    var flag = confirm("确定删除");
    //拿到当前行的ID
    var $cust= $(this).parents('tr').children('td');
    var id = $cust.eq(0).text();
    //console.log(id)
    if(flag) {
        $.ajax({
                url:"customer_delete.action",
                type:"post",
                async:false,
                dataType:'json',
                data:{"cust_id":id},
                success: function (data,textStatus,request) {

                }

              });
            }
    $(this).parents("tr").remove();
    })

// function del(cust_id){
//     var flag = confirm("确定删除");
//     if(flag){
//             $.ajax({
//                 url:"customer_delete.action",
//                 type:"post",
//                 async:false,
//                 dataType:'json',
//                 data:{"cust_id":cust_id},
//                 success: function (data,textStatus,request) {
//                     console.log(request)
//                      // if (stateCode===1) {
//                      //     window.alert("删除成功");
//                      //     window.location.reload();
//                      // }
//                 }
//             });
//     }
// }

function edit(obj){

    var $td= $(obj).parents('tr').children('td');
    var td_id = $td.eq(0).text();
    var td_name = $td.eq(1).text();
    // var td_source = $td.eq(2).text();
    // var td_industry = $td.eq(3).text();
    // var td_level = $td.eq(4).text();
    var td_phone = $td.eq(5).text();
    var td_email = $td.eq(6).text();

    $("#edit_id").val(td_id);
    $("#edit_name").val(td_name);
    // $("#edit_level").val(td_level);
    // $("#edit_industry").val(td_industry);
    // $("#edit_source").val(td_source);
    $("#edit_phone").val(td_phone);
    $("#edit_email").val(td_email);
}

function addCustomer() {
    $.ajax({
        url: "customer_save.action",
        type: "post",
        async: false,
        dateType: 'json',
        data: $('#addForm').serialize(),
        success: function (data,textStatus,request) {

            if (request.status===200) {
                //window.alert("添加成功");
                window.location.reload();
            }

        }
    });
}

function updateCustomer(){
    $.ajax({
        url: "customer_update.action",
        type: "post",
        async: false,
        dateType: 'json',
        data: $('#updateForm').serialize(),
        success: function (data,textStatus,request) {

            console.log(request.status)
            if(request.status===200){
                //window.alert("修改成功");
                window.location.reload();
            }
        }
    });
}

$(document).ready( function (){
    //设置bootstrapTable起始高度
    $( '#table' ).bootstrapTable('resetView',{
        height:400
    } );
    //当表格内容的高度小于外面容器的高度，容器的高度设置为内容的高度，相反时容器设置为窗口的高度-160
    // if($("#table").height()<$(".fixed-table-container").height()){
    //     $(".fixed-table-container").css({"padding-bottom":"0px",height:$("#table").height()+20});
    // }else{
    //     $(".fixed-table-container").css({height:$(window).height()-160});
    // }

});
