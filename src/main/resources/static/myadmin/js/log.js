$('#myTabs a').click(function (e) {
    $(this).tab('show');

    showLogData($($(this)[0]).attr("href"));
    return false;
});

showLogData("#request");


function showLogData(id){
    if($("#searchBox").val()!=""){
        searchLog(id);
        return;
    }

    id=id.replace("#","");
    ajaxRequest({
        url:"/ws/log/"+id,
        success:function(data){
            var list=data.data;
            $("#"+id+" tbody").html("");
            for(var i=0;i<list.length;i++){
                var tr="<tr>";
                for(var k in list[i]){
                    if(list[i][k]==null){

                    }else{
                        if(k=="time"){
                            list[i][k]=dateFormat(list[i][k]);
                        }

                        if(k=="delay"){
                            list[i][k]=list[i][k]+"ms";
                        }
                        tr+="<td>"+list[i][k]+"</td>\n";
                    }
                }
                tr+="</tr>";

                $("#"+id+" tbody").append(tr);
            }
        }
        ,
        errorMsg:"获取数据失败"
    })
}


// 清理点击按钮事件
$("#cleanButton").on("click",function(){
    showAlert("设置清理时间","<input type='date' id='cleanDate'/>",function(){
        ajaxRequest({
           url:"/ws/log/clean/"+$("#cleanDate").val(),
           method:"DELETE",
           success:function(data){
              showAlert("成功","清空日志成功:"+data.data,function(){
                  location.reload();
              });
           }
           ,
            error:function(data){
                showAlert("失败","清空日志失败:"+data.message,function(){
                    location.reload();
                });
            }
        });
    })
});

$("#searchBtn").on("click",function(){

});

function searchLog(id){
    id=id.replace("#","");
    $.ajax({
        url:"/ws/log/"+id+"?delay="+$("#searchBox").val()+"&token="+token,
        success:function(data){
            var list=data.data;
            $("#"+id+" tbody").html("");
            for(var i=0;i<list.length;i++){
                var tr="<tr>";
                for(var k in list[i]){
                    if(list[i][k]==null){

                    }else{
                        if(k=="time"){
                            list[i][k]=dateFormat(list[i][k]);
                        }

                        if(k=="delay"){
                            list[i][k]=list[i][k]+"ms";
                        }
                        tr+="<td>"+list[i][k]+"</td>\n";
                    }
                }
                tr+="</tr>";

                $("#"+id+" tbody").append(tr);
            }
        }
        ,
        error:function(data){
            showAlert("获取数据失败:"+data.message);
        }
    })
}