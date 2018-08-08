


$.ajax({
    url:"/ws/overview/visitor/over?token="+token,
    method:"GET",
    headers:{"Blog":"Restful"},
    success:function (data) {
        var map=data.data;
        for(var k in map){
            $("#"+k+"-avg h1").html(map[k]);
        }
        getVisitorTop();
        getPageTop();
    }
    ,
    error:function (data) {
        showAlert("错误","获取历史数据失败:"+data.status);
    }
});

function getVisitorTop(){
    ajaxRequest({
        url:"/ws/overview/visitor/visitorTop",
        success:function (data) {
            var list=data.data;
            var labelList=[];
            var dataList=[];
            for(var i=0;i<list.length;i++){
                for(var k in list[i]){
                    labelList.push(k);
                    dataList.push((list[i])[k]);
                }
            }
            createPieChart($("#visitor-top"),labelList,dataList,"访问统计");

        }
        ,
        errorMsg:"获取历史访客数据失败"
    });

}

function getPageTop(){
    ajaxRequest({
        url:"/ws/overview/visitor/visitorPage",
        success:function (data) {
            var map=data.data;
            var labelList=[];
            var dataList=[];
            for(var i in map){
                labelList.push(i);
                dataList.push(map[i]);
            }
            createDoughnutChart($("#page-top"),labelList,dataList,"分布");

        }
        ,
        errorMsg:"获取访客最常到访页面失败"
    });

}




