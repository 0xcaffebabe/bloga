//edge栏目关闭按钮们：


$(".close").on("click",function(){
   var t=$(this).parent().parent().parent().hide(800);
   setTimeout(function(){
      t.remove();
      if($("#edge").children().length==0){
         alert(0);
         $(".blog-main").removeClass("col-md-8");
      }
   },1000);


});