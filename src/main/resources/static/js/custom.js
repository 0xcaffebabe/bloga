

var url=location.pathname+location.search;

//提交URL到服务器并返回一个ID

var id;

$.ajax({
   url:"/ws/stayTime/id?url="+url,
    headers:{"Blog":"Restful"},
    success:function(data){
        id=data;
        console.log("取回ID成功，："+id);
        heartBeat();
    }
    ,
    error:function(data){
       console.log("取回ID失败，原因"+data.status);
    }

});

function heartBeat(){
    //定时给服务器发送心跳
    setInterval(function(){
        $.ajax({
            url:"/ws/stayTime/per/"+id,
            headers:{"Blog":"Restful"},
            success:function(data){
                console.log("心跳成功，："+data);
            }
            ,
            error:function(data){
                console.log("心跳失败，原因"+data.status);
            }

        });
    },10000);
}