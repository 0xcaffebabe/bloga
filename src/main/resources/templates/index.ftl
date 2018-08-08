<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>${webTitle!""}</title>
    <meta name="Keywords" Content="${keyWord!""}">
    <meta name="description" content="${description!""}">
    <meta name="viewport" content="width=device-width">

    <#include "style.ftl">


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


<#--<script>-->
    <#--$("#searchbox").keydown(function(e){-->
        <#--if(e.keyCode==13){-->
            <#--window.location="/search/"+this.value;-->
        <#--}-->
    <#--});-->
<#--</script>-->
</body>
</html>