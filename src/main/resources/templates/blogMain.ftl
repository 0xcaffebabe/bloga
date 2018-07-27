<div class="col-md-8 blog-main">
    <div class="row">
        <div class="page-header">
            <h1>${h1Title!"加载失败"}</h1>
        </div>
        <ol>
                    <#list articleList as i>
                        <article class="post">
                            <h2 class="post-title"><a href="/article/${i.id}" target="_blank">${i.title!"加载失败"}</a></h2>
                            <ul class="post-meta">
                                <li><span class='glyphicon glyphicon-user'></span>阅读数：${i.browseNumber!"加载失败"}</li>
                                <li><span class='glyphicon glyphicon-pencil'></span>'作者：${i.userName!"加载失败"}</li>
                                <li><span class='glyphicon glyphicon-time'></span>时间：${i.createTime?string('yyyy/MM/dd')!"加载失败"}</li>
                                <li><span class='glyphicon glyphicon-tag'></span>标签：
                                    <#assign tagColor=["primary",'success',"info","warning","danger"]>
                                    <#list i.tagSet as j>
                                        <a class='label label-${tagColor[j_index]!"加载失败"}' href='/tag/${j!"加载失败"}' target="_blank">
                                            ${j}
                                        </a>
                                    </#list>
                                </li>
                                <li><span class='glyphicon glyphicon-comment'></span><a href="Essay.jsp?id=72#comments">评论<span class='badge'>0</span></a></li>
                            </ul>
                            <div class="post-content">
                                ${i.content!"加载失败"}
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
        ${paging!"加载失败"}
        </div>
        </p>

    </div>
</div>