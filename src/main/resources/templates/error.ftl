<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>错误页面</title>
    <style>
        h1{
            font-size: 500%;
        }
        div{
            margin:0 auto;
        }
    </style>
</head>
<body>
    <div>
        <h2>啊！好像出了点问题</h2>
        <h1>:(</h1>
        出错原因:${msg!}
        </br>
        错误代码:${status}
        <b id="time"></b>
    </div>

</body>

<script>
    var count=5;
    var time=document.getElementById("time");
    action();
    function action(){
        time.innerHTML=count+"秒后返回首页";
        count--;
        setTimeout(action,1000);
        if(count==0){
            window.location="/";
        }
    }
</script>
</html>