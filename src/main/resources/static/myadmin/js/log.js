$('#myTabs a').click(function (e) {
    $(this).tab('show');

    showLogData($($(this)[0]).attr("href"));
    return false;
});

showLogData("#request");


function showLogData(id){
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