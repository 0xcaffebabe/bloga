
var token=location.search.substring(location.search.indexOf("?token=")+7,32+location.search.indexOf("?token=")+7);

//公共
$("#menuBtn").on("click",function(){
 	$("#leftNav").toggle(800);
 });

//处理数据跳转
$("a").on("click",function(){
   window.location=$(this).attr("href")+"?token="+token;
   return false;
});

if(location.pathname.indexOf("index.html")!=-1 ||location.pathname=="/myadmin/"){

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

//日期格式化
function dateFormat(dateStr){
    var datetime = new Date(dateStr);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
}

//取随机整数
function randomInt(min, max){
    var r = Math.random() * (max - min);
    var re = Math.round(r + min);
    re = Math.max(Math.min(re, max), min);

    return re;
}

//取中间文本
function getMiddleText(str,before,after) {
    var pre=str.indexOf(before);
    var next=str.indexOf(after);
    if(after==""){
        next=str.length;
    }

    if(pre==-1 || next==-1){
        return undefined;
    }
    return str.substring(pre+before.length,next);
}

