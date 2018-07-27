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