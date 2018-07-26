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

<#include "./header.ftl">

<div class="widewrapper main">
    <div class="container">
        <div class="row">
            <div class="col-md-8 blog-main">
                <div class="row">
                    <div class="page-header">
                        <h1>近期文章</h1>
                    </div>
                    <ol>
                    <#list articleList as i>
                        <article class="post">
                            <h2 class="post-title"><a href="/article/${i.id}" target="_blank">${i.title}</a></h2>
                            <ul class="post-meta">
                                <li><span class='glyphicon glyphicon-user'></span>阅读数：${i.browseNumber}</li>
                                <li><span class='glyphicon glyphicon-pencil'></span>'作者：${i.userName!}</li>
                                <li><span class='glyphicon glyphicon-time'></span>时间：${i.createTime?string('yyyy/MM/dd')}</li>
                                <li><span class='glyphicon glyphicon-tag'></span>标签：
                                    <#assign tagColor=["primary",'success',"info","warning","danger"]>
                                    <#list i.tagSet as j>
                                        <a class='label label-${tagColor[j_index]}' href='/tag/${j}' target="_blank">
                                            ${j}
                                        </a>
                                    </#list>
                                </li>
                                <li><span class='glyphicon glyphicon-comment'></span><a href="Essay.jsp?id=72#comments">评论<span class='badge'>0</span></a></li>
                            </ul>
                            <div class="post-content">
                                ${i.content}
                            </div>
                        </article>
                    </#list>
                    </ol>
                </div>

                <div class="row">

                </div>

                <div class="paging">
                    <p>翻页
                    <div class="black2">
                       ${paging}
                    </div>
                    </p>

                </div>
            </div>
           <#include "./edge.ftl">
        </div>
    </div>
</div>



<#include "./footer.ftl">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/index.js"></script>
</body>
</html>