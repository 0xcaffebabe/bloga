
//四个面板
var map;
$.ajax({
    url:"/ws/overview/today?token="+token,
    method:"GET",
    headers:{"Blog":"Restful"},
    success:function(data) {
        map=data.data;
        fillForthPane();
        getRegion();
        getBrowser();
        getTimeInterval();
    },
    error:function(data){
        showAlert("错误","错误原因:"+data.status+",详细信息:"+data.msg);
    }
});

function fillForthPane(){
    var paneList=["today-requests","today-visitors","today-pages","today-reads"];

    //循环显示识图
    for(var i in paneList){
        $("#"+paneList[i]+" h1").html(map[paneList[i]]);
    }
    var tendMap;
    //判断趋势
    $.ajax({
        url:"/ws/overview/olderDay/1?token="+token,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            tendMap=data.data;
            for(var i in paneList){
                if(tendMap[paneList[i].replace("today-","olderDay-")]
                        <map[paneList[i]]){
                    $("#"+paneList[i]+" span").addClass("glyphicon-arrow-up");
                }else{
                    $("#"+paneList[i]+" span").addClass("glyphicon-arrow-down");
                }
                // console.log(tendMap[paneList[i]]+"||"+map[paneList[i]]+"\n");
            }
        }
        ,
        error:function(data){
            showAlert("错误","原因:"+data.status+","+data.msg);
        }
    })
}


//获取数据并创建图表
function getRegion(){
    $.ajax({
        url:"/ws/overview/region?token="+token,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            var list=data.data;
            var labelList=[];
            var countList=[];
            for(var i=0;i<list.length;i++){
                labelList[i]=list[i].country+list[i].province+list[i].city;
                countList[i]=list[i].count;
            }
            var regionChart = new Chart($("#regionChart"), {
                type: 'bar',
                data: {
                    labels: labelList,
                    datasets: [{
                        label: '访问统计',
                        data: countList,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.6)',
                            'rgba(54, 162, 235, 0.6)',
                            'rgba(255, 206, 86, 0.6)',
                            'rgba(75, 192, 192, 0.6)',
                            'rgba(153, 102, 255, 0.6)',
                            'rgba(255, 159, 64, 0.6)',
                            'rgba(255, 99, 132, 0.6)',
                            'rgba(54, 162, 235, 0.6)',
                            'rgba(255, 206, 86, 0.6)',
                            'rgba(75, 192, 192, 0.6)',
                            'rgba(153, 102, 255, 0.6)'
                        ]
                    }]
                }
            });

        }
        ,
        error:function(data){
            showAlert("失败","获取地区数据失败,原因:"+data.status+","+data.msg);
        }
    })
}

function getBrowser(){
    $.ajax({
        url:"/ws/overview/browser?token="+token,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            var map;
            map=data.data;
            var labelList=[];
            var dataList=[];
            for(var i in map){
                labelList.push(i);
                dataList.push(map[i]);
            }
            var browserChart=new Chart($("#browserChart"),{
                type:"doughnut",
                data:{
                    labels:labelList,
                    datasets:[
                        {
                            label:"浏览器",
                            data:dataList,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.6)',
                                'rgba(54, 162, 235, 0.6)',
                                'rgba(255, 206, 86, 0.6)',
                                'rgba(75, 192, 192, 0.6)',
                                'rgba(153, 102, 255, 0.6)',
                                'rgba(255, 159, 64, 0.6)',
                                'rgba(255, 99, 132, 0.6)',
                                'rgba(54, 162, 235, 0.6)',
                                'rgba(255, 206, 86, 0.6)',
                                'rgba(75, 192, 192, 0.6)',
                                'rgba(153, 102, 255, 0.6)'
                            ]
                        }
                    ]
                }
            });
        }
        ,
        error:function(data){
            showAlert("错误","获取浏览器表格失败，原因:"+data.status+","+data.msg);
        }
    });
}

function getTimeInterval(){
    $.ajax({
        url:"/ws/overview/timeInterval?token="+token,
        method:"GET",
        headers:{"Blog":"Restful"},
        success:function(data){
            var map=data.data;
            var labelList=[];
            var dataList=[];
            for(var i in map){
                labelList.push(i);
                dataList.push(map[i]);
            }

            var timeChart=new Chart($("#timeChart"),{
                type:"line",
                data:{
                    labels:labelList,
                    datasets:[
                        {
                            label:"时段统计",
                            data:dataList,
                            backgroundColor:"rgba(55,102,255,0.6)"
                        }
                    ]
                }
            });

        }
        ,
        error:function(data){
            showAlert("错误","原因:"+data.status+","+data.msg);
        }
    });
}
