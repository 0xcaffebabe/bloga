
var articleList;

var pagingNumber;
var pageNumber=1;

var model="all";

getArticleList(pageNumber);


//默认文章分页数
function getIndexPagingNumber(){
    $.ajax({
        url:"/ws/article/paging?token="+token+"&pageNumber="+pageNumber+"&pagingNumber=10",
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            pagingNumber=data.data;

            showPaging();
        }
        ,
        error:function(data){
            showAlert("错误","获取页数失败:"+data.status+","+data.msg);
        }
    });
}

//搜索文章分页数
function getSearchPagingNumber(keyWord){
    $.ajax({
        url:"/ws/article/search/paging?token="+token+"&pageNumber="+pageNumber+"&pagingNumber=10&keyWord="+keyWord,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            pagingNumber=data.data;
            showPaging();
        }
        ,
        error:function(data){
            showAlert("错误","获取页数失败:"+data.status+","+data.msg);
        }
    });
}
//获取文章数据(默认)
function getArticleList(pageNumber){
    $.ajax({
        url:"/ws/article/page?token="+token+"&pageNumber="+pageNumber+"&pagingNumber=10",
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            articleList=data.data;
            showArticles();
            getIndexPagingNumber();


        }
        ,
        error:function(data){
            showAlert("错误","获取文章数据失败:"+data.status+","+data.msg);
        }
    });


}

//搜索获取文章数据
function getArticleBySearch(keyWord,pageNumber){
    $.ajax({
        url:"/ws/article/search?token="+token+"&pageNumber="+pageNumber+"&pagingNumber=10&keyWord="+keyWord,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            articleList=data.data;
            model="search";
            getSearchPagingNumber(keyWord);
            showArticles();
        }
        ,
        error:function(data){
            showAlert("错误","获取文章数据失败:"+data.status+","+data.msg);
        }
    });
}

//批量删除文章
function deleteArticleBatch(list){
    $.ajax({
        url:"/ws/article?token="+token,
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
//展示分页模块
function showPaging(){
    console.log(pageNumber);
    $("#article-paging").html("");

    $("#article-paging").append("<li ><a href=\"#\">&laquo;</a></li>");
    for(var i=1;i<=pagingNumber;i++){
        if(i==pageNumber){
            $("#article-paging").append("<li class=\"active\"><a href=\"#\">"+i+"</a></li>")
        }else{
            $("#article-paging").append("<li><a href=\"#\">"+i+"</a></li>")
        }
    }

    $("#article-paging").append(" <li><a href=\"#\">&raquo;</a></li>");

    //注册事件
    $("#article-paging a").on("click",function(){
        if($(this).text()=="»"){
            if(pageNumber==pagingNumber){
                showAlert("提示","这里已经是最后一页，不能再前进");
                return;
            }else{
                pageNumber=parseInt(pageNumber)+1;
            }

        }else if($(this).text()=="«"){
            if(pageNumber==1){
                showAlert("提示","这里已经是第一页，不能再后退");
                return;
            }else{
                pageNumber=parseInt(pageNumber)-1;
            }

        }else{
            pageNumber=parseInt($(this).text());
        }

        $("#article-paging li[class='active']").removeClass("active");
        $("#article-paging a:contains('"+pageNumber+"')").parent("li").addClass("active");
        if(model!="all"){
            getArticleBySearch($("#searchBox").val(),pageNumber);
        }else{
            getArticleList(pageNumber);
        }

        return false;
    });
}

function showArtivleViewer(articleId){

}

//展示文章数据
function showArticles(){
    //隐藏表格
    $("#article-main").hide();

    //如果文章列表大小=0
    if(articleList.length==0){
        $("#article-main").html("无数据");
    }else{
        $("#article-main").html("");
    }
    //对后台得到的数据进行html拼接
    var tr;
    for(var i=0;i<articleList.length;i++){
        var tags="";
        var tagColor=["primary",'success',"info","warning","danger"];


        for(var j=0;j<articleList[i].tagSet.length;j++){
           tags+="<a href=\"#\"><span class=\"label label-"+tagColor[randomInt(0,tagColor.length-1)]+
                "\">"+articleList[i].tagSet[j]+"</span></a>\n";

        }

        tr="<tr>\n" +
            "<td><input type=\"checkbox\" name=\"article-checked\" value='"+articleList[i].id+"'></td>\n" +
            "<td>"+articleList[i].id+"</td>\n" +
            "<td style='overflow: hidden;text-overflow:ellipsis;white-space: nowrap;max-width:180px;'><a href=\"#\">"+articleList[i].title+"</a></td>\n" +
            "<td>"+articleList[i].userName+"</td>\n" +
            "<td class=\"hidden-xs\">\n" +
            tags+
            "</td>\n" +
            "<td class=\"hidden-xs\">"+dateFormat(articleList[i].createTime)+"</td>\n" +
            "<td class=\"hidden-xs\">"+dateFormat(articleList[i].lastEditTime)+"</td>\n" +
            "<td><a href=''>"+articleList[i].browseNumber+"</a></td>\n" +
            "<td>0</td>\n" +
            "<td><button class='btn btn-warning' onclick='window.location=\"./write.html?token="+
            token+"&id="+articleList[i].id+"\"'>修改</button></td>"+
            "</tr>";
        tags="";
        $("#article-table #article-main").append(tr);
    }
    //拼接完成之后展示表格
    $("#article-main").show(500);

}

//搜索按钮事件
$("#searchBtn").on("click",function(){
    if($("#searchBox").val()==""){
       model="all";
        getArticleList(1);
    }else{
        model="search";
        getArticleBySearch($("#searchBox").val(),1);
    }

    pageNumber=1;
});

//清空按钮事件
$("#cleanBtn").on("click",function(){
    $("#searchBox").val("");
    model="all";
    getArticleList(1);
});

//发布按钮事件
$("#publishBtn").on("click",function(){
   window.location="./write.html?token="+token;
});

//删除按钮事件
$("#deleteBtn").on("click",function(){
    var list=document.getElementsByName("article-checked");

    var ret=[];
    for(var i in list){
       if(list[i].checked){
         ret.push(list[i].value);
       }
    }
    if(ret.length==0){
        showAlert("提示","请选择要删除的文章!");
        return;
    }
    deleteArticleBatch(ret);
})




