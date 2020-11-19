<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">PProject name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="<#if session_nav=="wenda">active</#if>"><a href="/wenda">问答</a></li>
                <li class="<#if session_nav=="blog">active</#if>"><a href="/blog">博客</a></li>
                <li class="<#if session_nav=="notice">active</#if>"><a href="/notice">通知</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <#if user??>
                <li class="set_btn user-card-box">
                    <a id="header-avator" class="user-card-item js-header-avator" action-type="my_menu" href="${request.contextPath}/u/${user.userId?c}" target="_self">
                        <img width="40" height="40" src='/${user.userAvatar}'>
                        <i class="myspace_remind" style="display: none;"></i>
                        <span style="display: none;">动态提醒</span>
                    </a>
                    <div class="g-user-card">
                        <div class="card-inner">

                        </div>
                    </div>
                </li>
                <li class="remind_warp">
                    <a target="_blank" href="#">
                        <i class="glyphicon glyphicon-time hover"></i>
                    </a>
                    <div class="guide-item-con clearfix">
                        <ul>
                            <li>
                                <a href="#">饿了么聋哑外卖小哥反复挂断用户电话：真相令人感动</a>
                                <p>浏览于2小时前</p>
                            </li>
                            <li>
                                <a href="#">饿了么聋哑外卖小哥反复挂断用户电话：真相令人感动</a>
                                <p>浏览于2小时前</p>
                            </li>
                        </ul>
                    </div>
                </li>
                <#else >
                <li><a href="javascript:;" id="js-signin-btn">登录</a></li>
                <li><a href="javascript:;" id="js-signup-btn">注册</a></li>
                </#if>
            </ul>
            <div id="search-box" class="l search-box">
                <form id="search-form" action="/search">
                    <input id="search-text" type="text" placeholder="" autocomplete="off">
                    <button id="search-btn" class="search-btn">
                        <i class="glyphicon glyphicon-search"></i><span>搜索</span>
                    </button>
                    <script>
                        $("#search-text").keydown(function(){
                            $.ajax({
                                type:"post",
                                url:"/search",
                                data:{words:$("#search-text").val()},
                                dataType:"json",
                                success:function(result){
                                    $(".search-result ul").empty();
                                    if(result.length >= 1){
                                        $(".search-result").css("display","block");
                                    }else{
                                        $(".search-result").css("display","none");
                                    }

                                    for(i=0;i<result.length;i++){
                                        $(".search-result ul").append('<li><a href="search/?words='+result[i]+'" target="_blank"><span class="cont"><i class="light">'+result[i]+'</i></span></a></li>');
                                    }
                                }
                            })
                        })
                    </script>
                    <div class="search-result">
                        <ul>
                            <li>
                                <a href="#" target="_blank">
                                    <span class="cont"><i class="light">我是传奇</i>1</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    <span class="cont"><i class="light">我是传奇</i>2</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    <span class="cont"><i class="light">我是传奇</i>3</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    <span class="cont"><i class="light">我是传奇</i>4</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    <span class="cont"><i class="light">我是传奇</i>5</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    <span class="cont"><i class="light">我是传奇</i>6</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </div>
</nav>