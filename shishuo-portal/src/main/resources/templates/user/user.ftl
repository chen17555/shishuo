<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${host.userNickname}的个人主页</title>
    <#include "../head.ftl">
    <script src="${request.contextPath}/static/js/vue.js"></script>
    <link rel="stylesheet" href="${request.contextPath}/static/css/user.css" />
</head>
<body>
<#include "../nav.ftl">
<div id="main">
    <div class="bg-other user-head-info">
        <div class="user-info">
            <h3 class="user-name clearfix">
                <span>${host.userNickname}</span>
            </h3>
            <p class="about-info">
                <span class="sexSecret" title=""></span>
                学生
                <span class="u-tiwen"></span>
                <span class="u-tiwen"></span>
                <span class="u-tiwen"></span>
            </p>
            <p class="user-desc" title="${host.userDesc}">${host.userDesc}</p>
            <div class="study-info">
                <div class="item follows">
                    <a href="#"><em>1</em></a>
                    <span>关注</span>
                </div>
                <div class="item followers">
                    <a href="/u/${host.userId}/fans"><em>1</em></a>
                    <span>粉丝</span>
                </div>
            </div>
        </div>
    </div>
    <div class="container main">
        <div class="wrap">
            <div class="slider">
                <div class="user-pic">
                    <div class="user-pic-bg"></div>
                    <img class="img" src="/${host.userAvatar}" alt="">
                </div>
                <ul>
                    <li>
                        <a href="/u/#{host.userId}" class="active">
                            <i class="glyphicon glyphicon-home"></i>
                            <span>主页</span>
                        </a>
                    </li>
                    <li>
                        <a href="/u/#{host.userId}/question">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>问答</span>
                        </a>
                    </li>
                    <li>
                        <a href="/u/#{host.userId}/blog">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>博客</span>
                        </a>
                    </li>
                    <#if user?? && host.userId == user.userId>
                    <li>
                        <a href="/u/#{host.userId}/history">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>历史</span>
                        </a>
                    </li>
                    </#if>
                    <#if user??>
                    <li>
                        <a href="/u/#{user.userId}/setting">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>设置</span>
                        </a>
                    </li>
                    </#if>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div id="u-container" class="u-container">
                <div class="article-main">
                    <div class="page-home" >
                        <p class="nodata">暂无任何动态</p>
                        <div id="pagenation" class="pagenation"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../footer.ftl">
</body>
<script>
    var vue = new Vue({
        el:"#u-container",
        data:{
            questionDatas:[],
            blogDatas:[],
            title:["我的问答","我的手记"],
            titleNum:0
        },
        created:function(){
            var url = window.location.href;
            if(url.indexOf("question") >= 0 ) {
                titleNum = 0;
                this.loadQuestionData();
            }else if(url.indexOf("blog") >= 0 ){
                titleNum = 1;
                this.loadBlogData();
            }
        },
        methods:{
            loadQuestionData:function(){
                $.ajax({
                    type:"post",
                    url:"/u/#{userId}/question",
                    dataType:'json',
                    success:function(result){
                        if(result.data.length == 0){
                            console.log("空空如也");
                        }else{
                            vue.questionDatas = result.data;
                        }
                    }
                })
            },
            loadBlogData:function(){
                $.ajax({
                    type:"post",
                    url:"/u/#{userId}/blog",
                    dataType:'json',
                    success:function(result){
                        if(result.data.length == 0){
                            console.log("空空如也");
                        }else{
                            vue.questionDatas = result.data;
                        }
                    }
                })
            }
        }
    })
</script>
</html>