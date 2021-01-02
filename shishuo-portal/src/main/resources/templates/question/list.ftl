<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>校园问答平台</title>
    <#include "../head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/question.css" />
</head>
<body>
    <#include "../nav.ftl">
    <#if tagInfo??>
    <div class="current-label">
        <img src="${tagInfo.tagImg}" alt="">
        <h3>${tagInfo.tagName}</h3>
        <p class="content" style="height: 28px;">${tagInfo.tagDesc}</p>
        <div class="show js-show"><i class="icon-down2"></i></div>
        <div class="follow" data-tag-id="${tagInfo.tagId}">关注</div>
    </div>
    </#if>
    <div class="container main">
        <div class="row wenda">
            <div class="col-lg-8 wenda-main">
                <div class="row wd-top-slogan">
                    <span>开发者的问答社区</span>
                    <a href="javascript:void(0)" id="js-quiz" >我要提问</a>
                </div>
                <div class="row nb">
                    <ul class="nav navbar-nav">
                        <#if questionPage == "recommend">
                        <li><a href="/wenda/recommend/1" class="active">推荐</a></li>
                        <li><a href="/wenda/new/1">最新</a></li>
                        <#--<li><a href="/wenda/waitreply/1">等待回答</a></li>-->
                        <#elseif  questionPage == "new">
                        <li><a href="/wenda/recommend/1" >推荐</a></li>
                        <li><a href="/wenda/new/1" class="active">最新</a></li>
                        <#--<li><a href="/wenda/waitreply/1">等待回答</a></li>-->
                        <#else >
                        <li><a href="/wenda/recommend/1" >推荐</a></li>
                        <li><a href="/wenda/new/1" >最新</a></li>
                        <#--<li><a href="/wenda/waitreply/1" class="active">等待回答</a></li>-->
                        </#if>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                       <#-- <li><a href="#">只显示关注内容</a></li>-->
                    </ul>
                </div>
                <#include "listBody.ftl"/>
                <div class="row page">
                    <#if pageInfo.isFirstPage>
                    <span class="disabled_page">首页</span>
                    <span class="disabled_page" >上一页</span>
                    <#else>
                    <a href="/wenda/${questionPage}/1">首页</a>
                    <a href="/wenda/${questionPage}/${pageInfo.prePage}">上一页</a>
                    </#if>
                    <ul>
                        <#list pageInfo.navigateFirstPage..pageInfo.navigateLastPage as i>
                            <#if i == pageInfo.pageNum>
                            <li><a class="text-page-tag active" href="javascript:void(0)">${i}</a></li>
                            <#else >
                            <li><a class="text-page-tag" href="/wenda/${questionPage}/${i}">${i}</a></li>
                            </#if>
                        </#list>
                    </ul>
                    <#if pageInfo.isLastPage>
                    <span class="disabled_page" >下一页</span>
                    <span class="disabled_page">尾页</span>
                    <#else >
                    <a href="${request.contextPath}/wenda/${questionPage}/${pageInfo.nextPage}">下一页</a>
                    <a href="${request.contextPath}/wenda/${questionPage}/${pageInfo.pages}">尾页</a>
                    </#if>
                </div>
            </div>
            <div class="col-lg-4 wenda-slider">
                <#if user??>
                <div class="row user-about">
                    <div class="user-info">
                        <div class="user-pic">
                            <a href="#">
                                <img src="${request.contextPath}/static/avatar/555e0b62000180e201000100-100-100.jpg" alt="暴躁的黑猫警长" />
                            </a>
                        </div>
                        <div class="user-name">
                            <a href="#">暴躁的黑猫警长</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="user-action">
                        <span class="ques"><a href="#">提问</a></span>
                        <span class="reply"><a href="#">回复</a></span>
                        <span class="follow"><a href="#">关注</a></span>
                    </div>
                </div>
                <div class="row my-follow-class">
                    <h3>我关注的分类<span class="js-open">+</span></h3>
                    <div class="tag-box clearfix">
                        <#if userTags??>
                            <#list userTags as tag>
                            <a href="/wenda/tag/${tag.tagId}">${tag.tagName}</a>
                            </#list>
                        </#if>
                    </div>
                </div>
                </#if>
                <#if recommendTags??>
                <div class="row recommend-class">
                    <div class="title clearfix">
                        <h3>推荐分类</h3>
                        <span class="all-cls">全部分类</span>
                    </div>
                    <ul class="cls-list">
                        <#list recommendTags as tag>
                        <li>
                            <div class="class-info">
                                <div class="class-icon">
                                    <a href="/wenda/tag/${tag.tagId}" target="_blank">
                                        <img src="${tag.tagImg}" alt="${tag.tagName}">
                                    </a>
                                </div>
                                <h4><a href="/wenda/tag/${tag.tagId}" target="_blank">${tag.tagName}</a></h4>
                                <p class="follow-person">14111人关注</p>
                                <a href="javascript:void(0)" data-tag-id="${tag.tagId}" class="follow">关注</a>
                            </div><!--.class-info end-->
                            <div class="desc">${tag.tagDesc}...</div>
                        </li><!--li end-->
                        </#list>
                    </ul>
                </div>
                </#if>
            </div>
        </div>
    </div>
    <#include "../footer.ftl">
    <script type="text/javascript" src="${request.contextPath}/static/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${request.contextPath}/static/js/bootstrap.min.js" ></script>
    <script>
        function load(){
            <#if user??>
            <#else >
            $("body").append(signinTpl);
            $("#signin").modal('show');
            </#if>
        }
        $("#js-quiz").click(function(){
            <#if user??>
                window.location.href = "/wenda/save";
            <#else >
                load();
            </#if>
        })
        $(".recommend-class ul li .follow").click(function(){
            load();
            <#if user??>
            $.ajax({
                type:'POST',
                url:'/follow/tag',
                data:{tagId:$(this).data("tagId")},
                dataType:'json',
                success:function (result) {
                    if(result.code == 0){
                        window.location.reload();
                    }
                }
            })
            </#if>
        })
    </script>
</body>
</html>
