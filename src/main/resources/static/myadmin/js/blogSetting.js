
ajaxRequest({
    url:"/ws/setting/site",
    success:function(data){
        var list=$("#main .col-md-9").children();

        for(var i=0;i<list.length;i++){

            if(data.data[list[i].id]==undefined){

            }else{
                list[i].value=data.data[list[i].id];
            }

        }
    },
    errorMsg:"获取网站设置失败"
});


//更新按钮事件
$("#updateBtn").on("click",function(){
   var list=$("#main .col-md-9").children();

    var map={};
   for(var i=0;i<list.length;i++){
       if(list[i].value==""){
           showAlert("提示","请将内容填写完整!");
           return;
       }
       map[list[i].id]=list[i].value;
   }
   updateBatch(map);

});

//批量更新
function updateBatch(map){
    var obj=JSON.stringify(map);



    $.ajax({
        url:"/ws/setting/batch?token="+token,
        headers:{'Blog' : "Restful","Content-Type":"application/json"},
        method:"POST",
        data:obj,
        success:function(data){
            showAlert("成功","更新成功，code:"+data.data,function(){
                location.reload();
            });
        }
        ,
        error:function(data){
            showAlert("错误","更新失败："+data.responseJSON.message);
        }
    });


}