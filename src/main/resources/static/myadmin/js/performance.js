


ajaxRequest({
    url:"/ws/overview/performance/today",
    success:function(data){
        var map=data.data;
        getInterval();
        var paneList=["today-sqls","today-sqls-response-time","today-response-time"];
        for(var i=0;i<paneList.length;i++){
            $("#"+paneList[i]+" h1").html(map[paneList[i]]);
        }
    }
    ,
    errorMsg:"获取今日性能分析数据失败"
});



function getInterval(){
    ajaxRequest({
        url:"/ws/overview/performance/interval",
        success:function(data){
            var list=data.data;
            createLineChart($("#sqlInterval"),
                [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23],list,"各时段SQL执行量");

        }
        ,
        errorMsg:"获取SQL各时段执行量数据失败"
    });

}
