
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>${article.title}</title>
    <meta name="keywords" content="ISMY博客,JAVA,WEB,网络">
    <meta name="description" content="众所周知，JavaScript因为浏览器的同源策略是有着跨域资源访问限制，那我们如何跨域发起一个get请求？那就是用img script等元素进行。使用JavaScript动态创建一个img元素，然后...">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="https://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css">

    <!-- Font-Awesome -->
    <link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic' rel='stylesheet' type='text/css'>

    <!-- Styles -->
    <link rel="stylesheet" href="/css/style.css" id="theme-styles">

    <!--[if lt IE 9]>
    <script src="/js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>

    <![endif]-->

    <style>
        img{
            display:block;height:auto;max-width:100%
        }
        .side-art li{
            margin-top:16px;
            font-size: 12px;
        }
        .label{
            margin-left:12px;

        }


    </style>
</head>
<body>





<#include "./header.ftl">


<div class="widewrapper main">
    <div class="container">
        <div class="row">
            <div class="col-md-8 blog-main">
                <article class="blog-post">
                    <header>

                        <div class="lead-image">


                        </div>
                    </header>
                    <div class="body">

                        <h3>${article.title}</h3>
                        <#assign tagColor=["primary",'success',"info","warning","danger"]>
                        <#list article.tagSet as j>
                           <a class='label label-${tagColor[j_index]}' href='tag.jsp?name=JAVA'>
                              ${j}
                            </a>
                        </#list>
                        <div class="meta">
                            <i class="fa fa-user"></i> ${article.userName}
                            <i class="fa fa-calendar"></i>${article.createTime?string('yyyy/MM/dd HH:mm:ss')}
                            <i class="fa fa-book">${article.browseNumber}浏览</i><i class="fa fa-comments"></i><span class="data"><a href="#comments">0 评论</a></span>
                        </div>


                        <ol class="breadcrumb">
                            <li><a href="/">主页</a></li>
                            <li class="active">当前位置</li>
                        </ol>

                        ${article.content}

                    </div>
                </article>

                <aside class="social-icons clearfix">
                    <h3>分享</h3>
                    <a href="javascript:shareQQ();"><i class="fa fa-qq"></i></a> <a href="#"><i class="fa fa-weibo"></i></a>
                </aside>
                <script>
                    function shareQQ(){
                        var url=encodeURI("www.ismy.wang/page/"+location.search.replace("?id=","")+".html");
                        var desc=encodeURI("内容分享");
                        var title=encodeURI(document.title);
                        var pics=encodeURI("https://ismy.wang/img/logo.png");
                        var ret="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url="+url+"&desc="+desc+"&title="+title+"&pics="+pics;
                        window.open(ret);
                    }
                </script>
                <aside class="comments" id="comments">
                    <hr>

                    <h2><i class="fa fa-comments"></i> 0 评论</h2>








                </aside>

                <aside class="create-comment" id="create-comment">
                    <hr>

                    <h2><i class="fa fa-pencil"></i> 评论</h2>

                    <form action="Comment" method="get" accept-charset="utf-8">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="text" name="name" id="comment-name" placeholder="你的昵称" class="form-control input-lg">
                            </div>
                            <div class="col-md-6">
                                <input type="email" name="email" id="comment-email" placeholder="电子邮件" class="form-control input-lg">
                            </div>
                        </div>
                        <input type="text" name="id" style="display: none;" value="72"/>
                        <input type="url" name="website" id="comment-url" placeholder="你的网址" class="form-control input-lg">

                        <textarea rows="10" name="message" id="comment-body" placeholder="你要说的" class="form-control input-lg"></textarea>

                        <div class="buttons clearfix">
                            <button type="submit" class="btn btn-xlarge btn-clean-one">提交</button>
                        </div>
                    </form>
                </aside>
            </div>








            <#include "./edge.ftl">
        </div>
    </div>
</div>



<#include "./footer.ftl">



<script src="https://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="/js/modernizr.js"></script>
<script src="/js/index.js"></script>
</body>
</html>
