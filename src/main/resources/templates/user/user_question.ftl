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
                        <a href="/u/#{host.userId}">
                            <i class="glyphicon glyphicon-home"></i>
                            <span>主页</span>
                        </a>
                    </li>
                    <li>
                        <a href="/u/#{host.userId}/question" class="active">
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
                    <ul class="clearfix toptab">
                        <#if user?? && host.userId == user.userId>
                            <li class="tabactive" ><a href="/u/#{host.userId}/blog">我的问答</a></li>
                            <li class=""><a href="/u/#{host.userId}/blog?sort=floower">我的收藏</a></li>
                            <li class=""><a href="/u/#{host.userId}/blog?sort=reply">我的评论</a></li>
                        <#else >
                            <li class="tabactive" ><a href="/u/#{host.userId}/blog">Ta的问答</a></li>
                            <li class=""><a href="/u/#{host.userId}/blog?sort=floower">Ta的收藏</a></li>
                            <li class=""><a href="/u/#{host.userId}/blog?sort=reply">Ta的评论</a></li>
                        </#if>
                    </ul>
                    <div class="articles-list"  v-for = "data in questionDatas">
                        <div class="list-item article-item ">
                            <h3 class="item-title">
                                <a target="_blank" :href="'/wenda/detail/'+data.questionId" class="title-detail">{{ data.questionTitle }}</a>
                            </h3>
                            <div class="">
                                <p class="item-bd">{{ data.questionContent }}</p>
                            </div>
                            <div class="item-btm clearfix">
                                <ul class="l left-info">
                                    <li class="hd-pic">
                                        <a class="publisher-name" :href="'/u/'+data.authorId+'/question'"  target="_blank">{{ data.authorName }}</a>
                                    </li>
                                </ul>
                                <div class="r right-info">
                                    <div class="favorite l">
                                        <i class="icon sns-thumb-up-outline"></i><em> {{ data.clickNum}}浏览</em>
                                    </div>
                                    <div class="favorite l">
                                        <i class="icon sns-thumb-up-outline"></i><em> 9推荐</em>
                                    </div>
                                    <div class=" l">
                                        <i class="icon sns-comment"></i><em> {{ data.answerNum }}评论</em>
                                    </div>
                                </div>
                            </div>
                        </div>
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
            blogDatas:[]
        },
        created:function(){
            this.loadQuestionData();
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
            }
        }
    })
</script>
</html>