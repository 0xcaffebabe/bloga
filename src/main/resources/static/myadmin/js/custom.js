
var token=location.search.replace("?token=","");

//替换掉系统的alert
window.alert=showAlert;

//公共
$("#menuBtn").on("click",function(){
 	$("#leftNav").toggle(800);
 });

if(location.pathname.indexOf("index.html")!=-1){

}else{
    checkToken();
}

//校验token是否有效
function checkToken(){
    if(token==undefined || token==""){
        showAlert("错误","登录超时",function(){
            location="./index.html";
        });
    }else{
        $.ajax({
            url:"/ws/user?token="+token,
            success:function(data){
                if(data.data==null){
                    showAlert("错误","登录超时",function(){
                        location="./index.html";
                    });
                }
            }

        });
    }
}

$("#context").show(1000);

//弹出一个提示框
function showAlert(title,content,callback){
    var modalStr="<div class=\"modal fade text-center\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n" +
        "    <div class=\"modal-dialog\">\n" +
        "        <div class=\"modal-content\">\n" +
        "            <div class=\"modal-header\">\n" +
        "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n" +
        "                <h4 class=\"modal-title\" id=\"myModalTitle\">"+title+"</h4>\n" +
        "            </div>\n" +
        "            <div class=\"modal-body\" id='myModalContent'>"+content+"</div>\n" +
        "            <div class=\"modal-footer\">\n" +
        "                <button type=\"button\" id='modal-sure' class=\"btn btn-primary\" data-dismiss=\"modal\">确定</button>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</div>";
    if($("#myModal").length>0){
        $("#myModalTitle").text(title);
        $("#myModalContent").text(content);
    }else{
        $("body").append(modalStr);
    }


    $("#myModal").modal("show");

    $("#myModal").on("hidden.bs.modal",callback);

}

