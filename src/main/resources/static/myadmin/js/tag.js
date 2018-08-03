
//获取所有标签

var tagList;
getAllTags();
function getAllTags(){
    $.ajax({
        url:"/ws/tag?token="+token,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            tagList=data.data;
            showTags();
        }
        ,
        error:function(data){
            showAlert("失败","获取标签数据失败:"+data.status);
        }
    });
}


function showTags(){
    var tr;
    $("#tags-main").hide();
    $("#tags-main").html("");
    for(var i=0;i<tagList.length;i++){
        tr="<tr>\n" +
            "\t\t\t\t\t<td><input type=\"checkbox\" name='tag-checked' value='"+tagList[i].id+"'></td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].id+"</td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].name+"</td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].relevant+"</td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].time+"</td>"
        $("#tags-main").append(tr);
    }
    $("#tags-main").show(500);
}

//搜索标签
function getTagBySearch(keyWord){
    $.ajax({
       url:"/ws/tag/search/"+keyWord+"?token="+token,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
           tagList=data.data;
           showTags();
        }
        ,
        error:function(data){
           showAlert("错误","获取标签数据失败:"+data.status);
        }
    });
}

//搜索按钮事件
$("#searchBtn").on("click",function(){
   var keyWord=$("#searchBox").val();
   if(keyWord==""){
       getAllTags
   }else{
       getTagBySearch(keyWord);
   }
});

$("#cleanBtn").on("click",function(){
   $("#searchBox").val("");
   getAllTags();
});

//新增按钮事件
$("#addBtn").on("click",function(){

   $("#addModal").modal("show");

});

$("#addModalSubmit").on("click",function(){
   var tag=$("#addModalTag").val();

   if(tag==""){

       return;
   }
    addTag(tag);


});

function addTag(name){
    var obj={"name":name};
    $.ajax({
        url:"/ws/tag?token="+token,
        method:"PUT",
        headers:{"Blog":"Restful","Content-Type":"application/json"},
        data:JSON.stringify(obj),
        success:function(data){
            if(data.data!=null){
                showAlert("成功","添加成功",function(){
                    location.reload();
                })
            }else{
                showAlert("错误","添加失败:"+data.status);
            }
        }
        ,
        error:function(data){
            showAlert("错误","添加失败:"+data.status);
        }
    });
}

//删除按钮事件
$("#deleteBtn").on("click",function () {
    var list=document.getElementsByName("tag-checked");

    var ret=[];
    for(var i in list){
        if(list[i].checked){
            ret.push(list[i].value);
        }
    }
    if(ret.length==0){
        showAlert("提示","请选择要删除的标签!");
        return;
    }
    deleteTagBatch(ret);
});

function deleteTagBatch(list){
    $.ajax({
       url:"/ws/tag?token="+token,
       method:"DELETE",
       headers:{"Blog":"Restful","Content-Type":"application/json"},
        data:JSON.stringify(list),
        success:function(data){
            showAlert("成功","删除标签成功，影响条数:"+data.data,function(){
                location.reload();
            });
        }
        ,
        error:function(data){
           showAlert("错误","删除标签失败:"+data.status);
        }
    });
}
