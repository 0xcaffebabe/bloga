<aside class="col-md-4 blog-aside" id="edge">

    <div class="aside-widget" style="margin-top:15px;" id="recommendList">
        <header>
            <h3>推荐文章 <button class="close" >&times;</button></h3>
        </header>

        <div class="container-fluid">
                        <#list edge["recommendArticles"] as recommend>
                            <div class="row page">
                                <div class="col-md-12 ">
                                    <h5><a href='/article/${recommend.id}' target="_blank">${recommend.title}</a></h5>
                                </div>
                            </div>
                            <div class="line"></div>
                        </#list>

        </div>
    </div>

    <div class="aside-widget" id="relateList">
        <header>
            <h3>相关文章<button class="close" >&times;</button></h3>
        </header>
        <div class="container-fluid"  style="">
                        <#list edge["relevantArticles"] as relevant>
                            <div class="row page">
                                <div class="col-md-12 ">
                                    <h5><a href='/article/${relevant.id}' target="_blank">${relevant.title}</a></h5>
                                </div>
                            </div>
                            <div class="line"></div>
                        </#list>
        </div>
    </div>

    <div class="aside-widget">
        <header>
            <h3>标签<button class="close" >&times;</button></h3>
        </header>
        <div class="body clearfix">
            <ul class="tags">
                <#list edge["tagList"] as tag>

                     <li><a href="/tag/${tag.name}" target="_blank">${tag.name}</a></li>
                </#list>

            </ul>
        </div>
    </div>

    <div class="aside-widget">
        <header>
            <h3>日期归档<button class="close" >&times;</button></h3>
        </header>
        <div class="body clearfix">
            <ul class="tags">
                <#list edge["fileList"] as file>

                    <li><a href="/file/${file}" target="_blank"> ${file}</a> </li>
                </#list>


            </ul>
        </div>
    </div>
</aside>
