<aside class="col-md-4 blog-aside">

    <div class="aside-widget" style="margin-top:15px;" id="recommendList">
        <header>
            <h3>推荐文章 <button class="close" id="recommendClose">&times;</button></h3>
        </header>

        <div class="container-fluid">
                        <#list edge["recommendArticles"] as recommend>
                            <div class="row page">
                                <div class="col-md-12 ">
                                    <h5><a href='Essay.jsp?id=3'>${recommend.title}</a></h5>
                                </div>

                            </div>
                            <div class="line"></div>
                        </#list>

        </div>
    </div>

    <div class="aside-widget" id="relateList">
        <header>
            <h3>相关文章 <button class="close" id="relateClose">&times;</button></h3>
        </header>
        <div class="container-fluid"  style="">
                        <#list edge["relevantArticles"] as relevant>
                            <div class="row page">
                                <div class="col-md-12 ">
                                    <h5><a href='Essay.jsp?id=3'>${relevant.title}</a></h5>
                                </div>
                            </div>
                            <div class="line"></div>
                        </#list>




        </div>
    </div>

    <div class="aside-widget">
        <header>
            <h3>标签</h3>
        </header>
        <div class="body clearfix">
            <ul class="tags">
                <#list edge["tagList"] as tag>

                     <li><a href="tag.jsp?name=JAVA">${tag.name}</a></li>
                </#list>

            </ul>
        </div>
    </div>

    <div class="aside-widget">
        <header>
            <h3>日期归档</h3>
        </header>
        <div class="body clearfix">
            <ul class="tags">
                <#list edge["fileList"] as file>

                    <li><a href="file.jsp?date=2018年6月">${file}</a> </li>
                </#list>


            </ul>
        </div>
    </div>
</aside>
