
//创建编辑器
var E = window.wangEditor;
var editor = new E('#editor');
var id=getMiddleText(location.search,"&id=","");



// 或者 var editor = new E( document.getElementById('editor') )
// //定时保存文章
editor.customConfig.onchange = function (html) {
    // 监控变化，同步更新
    saveContent();
    $("#tip").html("最近的一次保存:"+dateFormat(new Date()));
};
//上传图片设置
editor.customConfig.uploadImgServer = '/ws/upload?token='+token;
editor.customConfig.uploadImgHeaders = {
    'Blog': 'Restful'
};
editor.customConfig.uploadImgHooks = {
    before: function (xhr, editor, files) {
        // 图片上传之前触发
        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件

        // 如果返回的结果是 {prevent: true, msg: 'xxxx'} 则表示用户放弃上传
        // return {
        //     prevent: true,
        //     msg: '放弃上传'
        // }
    },
    success: function (xhr, editor, result) {
        // 图片上传并返回结果，图片插入成功之后触发
        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
    },
    fail: function (xhr, editor, result) {
        // 图片上传并返回结果，但图片插入错误时触发
        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
    },
    error: function (xhr, editor) {
        showAlert("提示","图片上传错误");
        // 图片上传出错时触发
        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
    },
    timeout: function (xhr, editor) {
        showAlert("提示","图片上传超时");
        // 图片上传超时时触发
        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
    },

    // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
    // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
    customInsert: function (insertImg, result, editor) {
        // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
        // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

        // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
        var url = result.data;
        insertImg(url)

        // result 必须是一个 JSON 格式字符串！！！否则报错
    }

};
editor.customConfig.uploadFileName = 'file';

editor.customConfig.zIndex = 0;
editor.create();

//设置编辑框图片高度自适应


var tagSet;
//获取所有标签
$.ajax({
    url:"/ws/tag?token="+token,
    method:"GET",
    headers:{"Blog":"Restful"},
    success:function(data){
        tagSet=data.data;
        $("#tags").append("<option selected></option>")
        for(var i=0;i<tagSet.length;i++){
            $("#tags").append("<option>"+tagSet[i].name+"</option>");
        }

        if(id){
            $("#submitBtn").html("更新文章");
            $.ajax({
                url:"/ws/article/"+id+"?token="+token,
                method:"GET",
                headers:{"Blog":"Restful"},
                success:function(data){
                    $("#article-title").val(data.data.title);
                    editor.txt.html(data.data.content);
                    var list=data.data.tagSet;
                    for(var i=0;i<list.length;i++){
                        var child='<span href="" class="label label-info">'+list[i]+'</span>';
                        $(child).insertBefore( $("#tag-pane input"));
                        $("#tags option:contains('"+list[i]+"')").hide();
                    }
                }
                ,
                error:function(data){
                    showAlert("错误","获取文章数据失败("+data.status+")");
                    id=undefined;
                }
            });
        }

    }
    ,
    error:function(data){
        showAlert("错误","获取标签数据失败("+data.status+")");
    }
});

getContent();

//
$("#tag-pane input").on("focus",function(){
    $("#tags").show(800);
});

$("#tag-pane").on("click","span",function(){
    $(this).hide(500);
    var that=this;
    setTimeout(function(){
        $("#tags option:contains('"+$(that).text()+"')").show(500);
        $(that).remove();
    },600);

});

$("#tags").on("change",function(e){
    var child='<span href="" class="label label-info">'+$("#tags option:selected").text()+'</span>';
    $("#tags option:selected").hide(500);
    $(child).insertBefore( $("#tag-pane input"));

});

$("#submitBtn").on("click",function(){
   var title=$("#article-title").val();

   var content=editor.txt.html();

   var tags="";

   $("#tag-pane span").each(function(index,value){
       tags+=$(value).html()+",";
   });
   tags=tags.substring(0,tags.length-1);
   if(title==""){
       showAlert("提示","请输入标题",function(){
           $("#article-title").focus();
       });
       return;
   }

   if(content==""){
       showAlert("提示","请输入内容");
       return;
   }
   if(tags==""){
       showAlert("提示","请选择标签");
       return;
   }
   if(id!=undefined){
       updateArticle(id,title,content,tags);
   }else{
       submitArticle(title,content,tags);
   }



});

//发布文章
function submitArticle(title,content,tags){
    var obj={

        "title":title,
        "content":content,
        "tags":tags
    }
    $.ajax({
        url:"/ws/article?token="+token,
        method:"PUT",
        headers:{"Blog":"Restful","Content-Type":"application/json"},
        data:JSON.stringify(obj)
        ,
        success:function(data){

            if(data.data!=null){
                showAlert("成功","发布成功",function(){
                    window.location="./article.html?token="+token;
                })
            }else{
                showAlert("错误","提交失败:"+data.status);
            }
        }
        ,
        error:function(data){
           showAlert("错误","提交失败:"+data.status);
        }
    });

}

//更新文章
function updateArticle(id,title,content,tags){
    var obj={
        "id":id,
        "title":title,
        "content":content,
        "tags":tags
    }
    $.ajax({
        url:"/ws/article?token="+token,
        method:"POST",
        headers:{"Blog":"Restful","Content-Type":"application/json"},
        data:JSON.stringify(obj)
        ,
        success:function(data){

            if(data.data!=null){
                showAlert("成功","更新成功",function(){
                    window.location="./article.html?token="+token;
                })
            }else{
                showAlert("错误","更新失败:"+data.status);
            }
        }
        ,
        error:function(data){
            showAlert("错误","更新失败:"+data.status);
        }
    });
}

function saveContent(){
    localStorage.content=editor.txt.html();
}

function getContent(){
    editor.txt.html(localStorage.content);
}