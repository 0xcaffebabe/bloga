//edge栏目关闭按钮们：
$(".close").on("click",function(){
   var t=$(this).parent().parent().parent().hide(800);
   setTimeout(function(){
      t.remove();
      if($("#edge").children().length==0){
         $(".blog-main").removeClass("col-md-8");
      }
   },1000);
});

//搜索事件

$("#searchForm").submit(function(e){
   var keyWord=$("#searchbox").val();
   window.location="/search/"+keyWord;
   return false;
});

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