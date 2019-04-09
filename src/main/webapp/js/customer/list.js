
    $(function(){
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
