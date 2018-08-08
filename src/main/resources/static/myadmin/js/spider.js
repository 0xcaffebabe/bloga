


getToday();

function getToday(){
    ajaxRequest({
        url:"/ws/overview/spider/today",
        success:function(data){
            getWhole();
            getTop10();
            getTend();
            getInterval();
            var map=data.data;
            var labelList=[];
            var dataList=[];
            for(var i in map){
                labelList.push(i);
                dataList.push(map[i]);

            }
            if(labelList.length==0){
                $("#todayChart").parent("div").html("今日没有蜘蛛到访");
            }else{
                createPieChart($("#todayChart"),labelList,dataList,"蜘蛛");
            }


        }
        ,
        errorMsg:"获取今日爬虫数据失败"
    });

}

function getWhole(){
    ajaxRequest({
        url:"/ws/overview/spider/whole",
        success:function(data){
            var map=data.data;
            var labelList=[];
            var dataList=[];
            for(var i in map){
                labelList.push(i);
                dataList.push(map[i]);
            }
            createDoughnutChart($("#wholeChart"),labelList,dataList,"历史蜘蛛");

        }
        ,
        errorMsg:"获取历史蜘蛛数据失败"
    });

}

function getTop10(){
    ajaxRequest({
        url:"/ws/overview/spider/top10",
        success:function(data){
            var list=data.data;
            var labelList=[];
            var dataList=[];
            for(var i=0;i<list.length;i++){
                var map=list[i];
                for(var j in map){
                    //如果要显示的连接太长，则截取后16位
                    if(j.length>16){
                        labelList.push(j.substring(j.length-16,16));
                    }else{
                        labelList.push(j);
                    }

                    dataList.push(map[j]);

                }
            }
            createBarChart($("#pageChart"),labelList,dataList,"爬虫最爱的五个页面");

        }
        ,
        errorMsg:"获取爬虫最爱页面失败"
    });

}

function getTend(){
    ajaxRequest({
        url:"/ws/overview/spider/tend",
        success:function(data){
            var list=data.data;
            var labelList=[];
            var dataList=list;
            //如果dataList不足7
            if(dataList.length<7){
                //那就湊到7
                for(var i=0;i<7-dataList.length;i++){
                    dataList.push(0);
                }
            }
            dataList.reverse();

            for(var i=6;i>=0;i--){
                var date=new Date();
                date.setDate(date.getDate()-i);
                labelList.push(simpleDateFormat(date));
            }
            createLineChart($("#tendChart"),labelList,dataList,"近7日爬虫访问情况");

        }
        ,
        errorMsg:"获取近7日爬虫数据情况失败"
    });

}

function getInterval(){
    ajaxRequest({
        url:"/ws/overview/spider/interval",
        success:function(data){
            var list=data.data;
            var dataList=list;
            createLineChart($("#intervalChart"),
                [0,1,2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23],
                dataList,"爬虫最常来访的时间段");


        }
        ,
        errorMsg:"获取爬虫最爱时间段数据失败"
    });

}











