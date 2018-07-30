
//四个面板
var map;
$.ajax({
    url:"/ws/overview/today?token="+token,
    method:"GET",
    success:function(data) {
        map=data.data;
        fillForthPane();
    },
    error:function(data){
        alert("错误","错误原因:"+data.status);
    }
});

function fillForthPane(){
    //今日请求数
    $("#today-request h1").html(map["todayRequests"]);
    //今日访客数
    $("#today-visitor h1").html(map["今日访客数"]);
    //今日页访数
    $("#today-pages h1").html(map["今日页访数"]);
    //今日阅读数
    $("#today-reads h1").html(map["今日阅读数"]);
}

//表格的创建
var reginChart = new Chart($("#reginChart"), {
  type: 'bar',
  data: {
    labels: ["福建", "广东", "江苏", "浙江", "北京", "美国", "西藏", "内蒙古", "俄罗斯", "日本"],
    datasets: [{
      label: '访问统计',
      data: [368855, 43654, 40001, 38645, 34352, 25260, 18660, 17588, 14306, 1469],
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

 var browserChart=new Chart($("#browserChart"),{
 	type:"doughnut",
 	data:{
 		labels:["Chrome","FireFox","Edge","IE","未知"],
 		datasets:[
 			{
 				label:"浏览器",
 				data:[4000,300,100,50,26],
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

 var timeChart=new Chart($("#timeChart"),{
 	type:"line",
 	data:{
 		labels:["1","2","3","4","5",7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,0],
 		datasets:[
 			{
 				label:"时段统计",
 				data:[180,360,401,550,586,7800,90,0,0,50,78,60,13,45,78,60,56,12,55,580,76,86,0],
 				backgroundColor:"rgba(55,102,255,0.6)"
 			}
 		]
 	}
 })