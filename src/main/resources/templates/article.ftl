
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>${webTitle!""}</title>
    <meta name="keywords" content="${keyWord}">
    <meta name="description" content="${description}">
    <meta name="viewport" content="width=device-width">

    <#include "style.ftl">



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
                           <a class='label label-${tagColor[j_index]}' href=/tag/${j}'>
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
                        var url=encodeURI("www.ismy.wang"+location.pathname);
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

                    <form  method="get" accept-charset="utf-8">
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
                            <button type="submit" class="btn btn-xlarge btn-clean-one" onclick="alert('还没写好');return false;">提交</button>
                        </div>
                    </form>
                </aside>
            </div>








            <#include "./edge.ftl">
        </div>
    </div>
</div>



<#include "./footer.ftl">



<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/modernizr.js"></script>
<script src="/js/index.js"></script>
<script src="/js/custom.js"></script>
</body>
</html>
