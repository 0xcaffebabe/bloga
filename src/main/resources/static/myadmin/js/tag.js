
//获取所有标签

var tagList;
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

function showTags(){
    var tr;

    for(var i=0;i<tagList.length;i++){
        tr="<tr>\n" +
            "\t\t\t\t\t<td><input type=\"checkbox\"></td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].id+"</td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].name+"</td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].relevant+"</td>\n" +
            "\t\t\t\t\t<td>"+tagList[i].time+"</td>"
        $("#tags-main").append(tr);
    }

}