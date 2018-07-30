<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>${webTitle}</title>
    <meta name="Keywords" Content="<%=sys.getValue("index-keyword")%>">
    <meta name="description" content="<%=sys.getValue("index-description")%>">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Font-Awesome -->
    <link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->

    <!-- Styles -->
    <!--[if lt IE 9]>
    <script src="/js/vendor/google/html5-3.6-respond-1.1.0.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/htmleaf-demo.css">
    <link rel="stylesheet" href="/css/pages.css">
    <link rel="stylesheet" href="/css/article.css"/>
    <link rel="stylesheet" href="/css/style.css" id="theme-styles">
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
            <#include "./blogMain.ftl">
           <#include "./edge.ftl">
        </div>
    </div>
</div>



<#include "./footer.ftl">

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/modernizr.js"></script>

</body>
</html>