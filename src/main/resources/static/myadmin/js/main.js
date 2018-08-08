
//四个面板
var map;
ajaxRequest({
    url: "/ws/overview/today",
    success:function(data) {
        map=data.data;
        fillForthPane();
        getRegion();
        getBrowser();
        getTimeInterval();
    },
    errorMsg:"获取今日概览数据失败"
});


function fillForthPane(){
    var paneList=["today-requests","today-visitors","today-pages","today-reads"];
    //循环显示识图
    for(var i in paneList){
        $("#"+paneList[i]+" h1").html(map[paneList[i]]);
    }
    //判断趋势
    var tendMap;
    ajaxRequest({
        url:"/ws/overview/olderDay/1",
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
        errorMsg:"渲染数据概览趋势失败"
    });

}


//获取数据并创建图表
function getRegion(){
    ajaxRequest({
        url:"/ws/overview/region",
        success:function(data){
            var list=data.data;
            var labelList=[];
            var countList=[];
            for(var i=0;i<list.length;i++){
                labelList[i]=list[i].country+list[i].province+list[i].city;
                countList[i]=list[i].count;
            }
            createBarChart($("#regionChart"),labelList,countList,"地区访问统计");


        }
        ,
        errorMsg:"获取地区访问统计数据失败"
    });

}

function getBrowser(){
    ajaxRequest({
        url:"/ws/overview/browser",
        success:function(data){
            var map;
            map=data.data;
            var labelList=[];
            var dataList=[];
            for(var i in map){
                labelList.push(i);
                dataList.push(map[i]);
            }
            createDoughnutChart($("#browserChart"),labelList,dataList,"浏览器分布")
        }
        ,
        errorMsg:"获取浏览器排行数据失败"
    });

}

function getTimeInterval(){
    ajaxRequest({
        url:"/ws/overview/timeInterval",
        success:function(data){
            var map=data.data;
            var labelList=[];
            var dataList=[];
            for(var i in map){
                labelList.push(i);
                dataList.push(map[i]);
            }
            createLineChart($("#timeChart"),labelList,dataList,"各时段请求量");
        }
        ,
        errorMsg:"各时段请求类数据请求失败"
    });

}
