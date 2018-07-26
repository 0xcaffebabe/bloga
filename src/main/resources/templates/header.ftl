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
                    <li><a href="/">首页</a></li>
                    <li><a href="/about">关于</a></li>
                    <li><a href="/contact">联系</a></li>
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