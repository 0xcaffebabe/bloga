<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>博客首页</title>
    <meta name="Keywords" Content="<%=sys.getValue("index-keyword")%>">
    <meta name="description" content="<%=sys.getValue("index-description")%>">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="https://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css">

    <!-- Font-Awesome -->
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->

    <!-- Styles -->


    <!--[if lt IE 9]>
    <script src="js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <link rel="stylesheet" href="css/pages.css">
    <link rel="stylesheet" href="css/article.css"/>
    <link rel="stylesheet" href="css/style.css" id="theme-styles">
    <style>
        .recent-art{
            margin-top:32px;
            font-size: 14px;
        }
        .recent-art a:hover{
            color:black;
        }

        .side-art li{
            margin-top:16px;
            font-size: 12px;
        }


    </style>
</head>
<body>

<header>
    <nav class="nav navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" data-toggle="collapse" data-target="#myNav">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <img src="img/logo.png" alt="" class="center-block">
            </div>
            <div id="myNav" class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right text-center">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="about.jsp">关于</a></li>
                    <li><a href="contact.jsp">联系</a></li>
                </ul>

                <form  action="search.jsp" method="get" accept-charset="utf-8" class="navbar-form navbar-right" id="searchForm">
                    <div class="form-group">
                        <div class="input-group">
                            <input id="searchbox" name="searchbox" type="text" class="form-control" placeholder="输入内容后按下回车以搜索" value="">
                            <span id="searchbtn" class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
                        </div>
                    </div>

                </form>
            </div>
        </div>

    </nav>

</header>

<div class="alert alert-info alert-dismissible text-center" role="alert" style="margin-top:50px;display: none;" id="board">
    <button type="button" class="close" id="boardClose"><span aria-hidden="true">&times;</span></button>
    <strong>公告：</strong>大家好，我是渣渣辉
</div>

<div class="widewrapper main">
    <div class="container">
        <div class="row">
            <div class="col-md-8 blog-main">
                <div class="row">
                    <div class="page-header">
                        <h1>近期文章</h1>
                    </div>
                    <ol>

                        <article class="post">
                            <h2 class="post-title"><a href="Essay.jsp?id=72">JAVASCRIPT跨域发起GET请求</a></h2>
                            <ul class="post-meta">
                                <li><span class='glyphicon glyphicon-user'></span>阅读数：119</li>
                                <li><span class='glyphicon glyphicon-pencil'></span>'作者：ismy</li>
                                <li><span class='glyphicon glyphicon-time'></span>时间：2018-06-02</li>
                                <li><span class='glyphicon glyphicon-tag'></span>标签：
                                    <a class='label label-primary' href='tag.jsp?name=JAVA'>JAVA</a>,<a class='label label-info' href='tag.jsp?name=WEB'>WEB</a>,<a class='label label-success' href='tag.jsp?name=网络'>网络</a>                                </li>
                                <li><span class='glyphicon glyphicon-comment'></span><a href="Essay.jsp?id=72#comments">评论<span class='badge'>0</span></a></li>
                            </ul>
                            <div class="post-content">
                                <p>众所周知，JavaScript因为浏览器的同源策略是有着跨域资源访问限制，那我们如何跨域发起一个get请求？</p>
                                <p>那就是用img script等元素进行。</p><p>使用JavaScript动态创建一个img元素，然后更新：<br/></p>
                                <pre class="brush:js;toolbar:false">	var&nbsp;img=document.createElement(&quot;img&quot;);
	img.src=&quot;http://www.baidu.com&quot;;
	document.appendChild(img);</pre><p>这样就对baidu发起了一个get请求，不过缺点显而易见，无法获取响应信息。<br/></p>
                            </div>
                        </article>


                    </ol>


                </div>

                <div class="row">

                </div>

                <div class="paging">

                    <p>翻页
                    <div class="black2">

                        <span class="disabled"> < </span> <span class="current">1</span><a href="./?page=2">2</a><a href="./?page=3">3</a><a href="./?page=4">4</a><a href="./?page=5">5</a><a href="./?page=6">6</a>...<a href="./?page=14">14</a><a href="./?page=2">></a>

                    </div>
                    </p>

                </div>
            </div>
            <%@include file="aside.jsp"%>

            <aside class="col-md-4 blog-aside">

                <div class="aside-widget" style="margin-top:15px;" id="recommendList">
                    <header>
                        <h3>推荐文章 <button class="close" id="recommendClose">&times;</button></h3>
                    </header>

                    <div class="container-fluid">

                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=3'>使用安全的HTML编码函数解决XSS攻击</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=4'>首次登陆CentOS以及man page求助</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=2'>JAVA使用预编译防止SQL注入</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=1'>第一个JAVA程序</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=17'>linux安装tomcat</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=7'>python搭建Django环境</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=19'>linux中解决mysql的 this is incompatible with sql_mode=only_full_group_by</a></h5>
                            </div>

                        </div>




                    </div>
                </div>

                <div class="aside-widget" id="relateList">
                    <header>
                        <h3>相关文章 <button class="close" id="relateClose">&times;</button></h3>
                    </header>
                    <div class="container-fluid"  style="">
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=72'>JAVASCRIPT跨域发起GET请求</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=71'>JAVASCRIPT动态创建样式表</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=70'>JAVASCRIPT动态加载js文件</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=69'>JAVASCRIPT遍历某一元素的所有子元素</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=68'>JAVA强制虚拟机进行内存回收</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=67'>JAVASCRIPT跳转到指定网址</a></h5>
                            </div>

                        </div>
                        <div class="line"></div>
                        <div class="row page">
                            <div class="col-md-12 ">
                                <h5><a href='Essay.jsp?id=66'>SQL注入简介</a></h5>
                            </div>

                        </div>



                    </div>
                </div>

                <div class="aside-widget">
                    <header>
                        <h3>标签</h3>
                    </header>
                    <div class="body clearfix">
                        <ul class="tags">
                            <li><a href="tag.jsp?name=JAVA">JAVA</a></li>
                            <li><a href="tag.jsp?name=PYTHON">PYTHON</a></li>
                            <li><a href="tag.jsp?name=LINUX">LINUX</a></li>
                            <li><a href="tag.jsp?name=SQL">SQL</a></li>
                            <li><a href="tag.jsp?name=MYSQL">MYSQL</a></li>
                            <li><a href="tag.jsp?name=WEB">WEB</a></li>
                            <li><a href="tag.jsp?name=KALI">KALI</a></li>
                            <li><a href="tag.jsp?name=网络">网络</a></li>
                            <li><a href="tag.jsp?name=JAVASCRIPT">JAVASCRIPT</a></li>
                            <li><a href="tag.jsp?name=HTML">HTML</a></li>
                            <li><a href="tag.jsp?name=CSS">CSS</a></li>



                        </ul>
                    </div>
                </div>

                <div class="aside-widget">
                    <header>
                        <h3>日期归档</h3>
                    </header>
                    <div class="body clearfix">
                        <ul class="tags">
                            <li><a href="file.jsp?date=2018年6月">2018年6月</a> </li>
                            <li><a href="file.jsp?date=2018年5月">2018年5月</a> </li>
                            <li><a href="file.jsp?date=2018年4月">2018年4月</a> </li>
                            <li><a href="file.jsp?date=2018年3月">2018年3月</a> </li>


                        </ul>
                    </div>
                </div>
            </aside>
        </div>
    </div>
</div>


        </div>
    </div>
</div>



<footer>
    <div class="widewrapper footer">
        <div class="container">
            <div class="row">

                <p style="text-align: center">一切源于兴趣|闽ICP备17018216号</p>
                <p style="text-align: center" id="display">
                </p>

            </div>
        </div>
    </div>



    <script src="./js/json/json_parse.js"></script>
    <script>
        setTimeout(function () {
            var xml=new XMLHttpRequest();
            xml.open("get","/Footer",false);
            xml.send(null);
            var obj=json_parse(xml.responseText);
            var month=obj.month;
            var day=obj.day;
            var min=obj.min;
            var display=document.getElementById("display");
            display.innerHTML="最近半月访客数："+month+"|今日访客数："+day+"|五分内线上有"+min+"人";
        },500);

    </script>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <div class="widewrapper copyright">
        Copyright 2018 <a href="#" target="_blank" title="ISMY">ISMY</a>
    </div>
</footer>




<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.js"></script>

</body>
</html>