


var settingList;

var editId;
//获取所有的设置
getSettings();
function getSettings(){
    ajaxRequest({
        url:"/ws/setting",
        success:function(data){
            settingList=data.data;
            showSettings();
        }
        ,
        errorMsg:"获取设置数据失败"
    });

}

//搜索设置
function getSettingBySearch(keyWord){

    ajaxRequest({
        url:"/ws/setting/search/"+keyWord,
        success:function(data){
            settingList=data.data;
            showSettings();
        }
        ,
        errorMsg:"获取设置数据失败"
    });

}

function showSettings(){
    $(" #settings-main").hide();
    var tr;
    $("#setting-table tbody").html("");
    for(var i=0;i<settingList.length;i++){
        tr="<tr>\n" +
            "<td><input type='checkbox' name='setting-checked' value='"+settingList[i].id+"'/></td>\n"+
            "\t\t\t\t\t\t<td>"+settingList[i].settingKey+"<span class=\"label label-success\">"+settingList[i].remarks+"</span>\n" +
            "\t\t\t\t\t\t\t<button class=\"btn btn-warning\" onclick='" +
            "editSetting("+settingList[i].id+")' style=\"float: right;margin-left : 10px;\">编辑</button>\n" +
            "\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t</tr>";
        $(" #settings-main").append(tr);
    }
    $(" #settings-main").toggle(400);

}

//增加一个设置
function addSetting(key,value,remarks){
    var obj={"settingKey":key,"settingValue":value,"remarks":remarks};
    ajaxRequest({
        url:"/ws/setting",
        method:"PUT",
        data:JSON.stringify(obj),
        success:function(data){
            if(data.data!=null){
                showAlert("成功","添加成功",function(){
                    location.reload();
                });
            }else{
                showAlert("错误","添加失败");
            }

        }
        ,
        errorMsg:"添加设置失败"
    });

}

//更新设置
function updateSetting(id,key,value,remarks){
    var obj={"id":id,"settingKey":key,"settingValue":value,"remarks":remarks};
    // ajaxRequest({
    //     url:"/ws/setting",
    //     method:"POST",
    //     data:JSON.stringify(obj),
    //     success:function(data){
    //         if(data.data!=null){
    //             showAlert("成功","更新成功，受影响条数:"+data.data,function(){
    //                 location.reload();
    //             });
    //         }else{
    //             showAlert("错误","更新失败");
    //         }
    //
    //     }
    //     ,
    //     errorMsg:"更新设置数据失败"
    // })
    $.ajax({
        url:"/ws/setting?token="+token,
        method:"POST",
        headers:{"Blog":"Restful","Content-Type":"application/json"},
        data:JSON.stringify(obj),
        success:function(data){
            if(data.data!=null){
                showAlert("成功","更新成功，受影响条数:"+data.data,function(){
                    location.reload();
                });
            }else{
                showAlert("错误","更新失败");
            }

        }
        ,
        error:function(data){
            showAlert("失败","更新设置数据失败:"+data.status+","+data.msg);
        }
    });
}

//增加设置提交按钮事件
$("#addModalSubmit").on("click",function(){
   var key=$("#addModalKey").val();

   var value=$("#addModalValue").val();

   var remarks=$("#addModalRemarks").val();

   if(key==""){
       $("#addModalKey").css("border","1px red solid");
       $("#addModalKey").on("focus",function(){
           $("#addModalKey").css("border","1px solid rgb(204,204,204)");
       });
       return;
   }

   if(value==""){
       $("#addModalValue").css("border","1px red solid");
       $("#addModalValue").on("focus",function(){
           $("#addModalValue").css("border","1px solid rgb(204,204,204)");
       });
       return;
   }

    if(remarks==""){
        $("#addModalRemarks").css("border","1px red solid");
        $("#addModalRemarks").on("click",function(){
            $("#addModalRemarks").css("border","1px solid rgb(204,204,204)");
        });
        return;
    }

    addSetting(key,value,remarks);
});

//编辑设置
function editSetting(id){
    var setting;
    ajaxRequest({
        url:"/ws/setting/id/"+id,
        success:function(data){
            setting=data.data;
            editId=data.data.id;
            $("#editModalKey").val(setting.settingKey);
            $("#editModalValue").val(setting.settingValue);
            $("#editModalRemarks").val(setting.remarks);
            $("#editModal").modal("show");
        }
        ,
        errorMsg:"获取设置失败"
    });
    // $.ajax({
    //     url:"/ws/setting/"+id+"?token="+token,
    //     method:"GET",
    //     headers:{"Blog":"Restful"},
    //     success:function(data){
    //         setting=data.data;
    //         editId=data.data.id;
    //         $("#editModalKey").val(setting.settingKey);
    //         $("#editModalValue").val(setting.settingValue);
    //         $("#editModalRemarks").val(setting.remarks);
    //         $("#editModal").modal("show");
    //        }
    //     ,
    //     error:function(data){
    //         showAlert("失败","获取设置失败:"+data.status);
    //     }
    // });

}

//编辑设置按钮事件
$("#editModalSubmit").on("click",function(){
    var key=$("#editModalKey").val();

    var value=$("#editModalValue").val();

    var remarks=$("#editModalRemarks").val();

    if(key==""){
        $("#editModalKey").css("border","1px red solid");
        $("#editModalKey").on("focus",function(){
            $("#editModalKey").css("border","1px solid rgb(204,204,204)");
        });
        return;
    }

    if(value==""){
        $("#editModalValue").css("border","1px red solid");
        $("#editModalValue").on("focus",function(){
            $("#editModalValue").css("border","1px solid rgb(204,204,204)");
        });
        return;
    }

    if(remarks==""){
        $("#editModalRemarks").css("border","1px red solid");
        $("#editModalRemarks").on("click",function(){
            $("#editModalRemarks").css("border","1px solid rgb(204,204,204)");
        });
        return;
    }

    updateSetting(editId,key,value,remarks);
});

//搜索按钮
$("#searchBtn").on("click",function(){
   var keyWord=$("#searchBox").val();
   if(keyWord==""){
        getSettings();
   }else{
       getSettingBySearch(keyWord);
   }
});


//清空按钮
$("#cleanBtn").on("click",function(){
   $("#searchBox").val("");
   getSettings();
});

$("#deleteBtn").on("click",function(){
    var list=document.getElementsByName("setting-checked");
    var ret=[];
    for(var i in list){
        if(list[i].checked){
            ret.push(list[i].value);
        }
    }
    if(ret.length==0){
        showAlert("提示","请选择要删除的设置!");
        return;
    }
    console.log(ret);
   deleteSettingBatch(ret);
});

//批量删除
function deleteSettingBatch(list){
    $.ajax({
        url:"/ws/setting?token="+token,
        method:"DELETE",
        headers:{"Blog":"Restful","Content-Type":"application/json"},
        data:JSON.stringify(list),
        success:function(data){
            showAlert("成功","操作成功，影响条数："+data.data,function(){
                location.reload();
            });
        }
        ,
        error:function (data) {
            showAlert("错误","删除失败:"+data.status);
        }
    });
}