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