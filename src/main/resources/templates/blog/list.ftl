<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>校园问答平台</title>
    <#include "../head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/blog.css" />
</head>
<body>
    <#include "../nav.ftl">
    <div class="container main">
        <div class="row article">
            <div class="col-lg-8 article-left l">
                <div class="ad-create">
                    <span class="icon icon-close"></span>
                    <h3>用博客的方式，学习前沿流行技术</h3>
                    <a href="/blog/save" target="_blank" class="create-ques">创建博客</a>
                </div>

                <div class="tag-wrap" style="display: none">
                    <div class="article-tab">
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a data-id = "2" href="#" target="_blank">PHP</a>
                        <a class="all">更多</a>
                        <div id="tagPop" class="tag-pop-layer">
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                            <a data-id = "2" href="#" target="_blank">PHP</a>
                        </div>
                    </div>
                </div>
                <div class="article-tool-bar clearfix">
                    <div class="tool-left l">
                        <#if blogPage = "recommend">
                            <a href="/blog/recommend/1" data-hot="hot" class="sort-item active">推荐</a>
                            <a href="/blog/new/1" class="sort-item">新上榜</a>
                        <#else >
                            <a href="/blog/recommend/1" data-hot="hot" class="sort-item">推荐</a>
                            <a href="/blog/new/1" class="sort-item active">新上榜</a>
                        </#if>

                    </div>
                </div>
                <#if pageInfo ??>
                <#list pageInfo.list as blog>
                    <div class="article-lwrap">
                        <h3 class="item-title">
                            <a href="/blog/detail/${blog.blogId?c}" class="title-detail" target="_blank">${blog.blogTitle}</a>
                            <span class="original">原创</span>
                        </h3>
                        <div>
                            <p class="item-bd">
                                ${blog.blogContent}
                            </p>
                            <div class="item-btm">
                                <ul class="l left-info">
                                    <li class="hd-pic">
                                        <a class="publisher-name">${blog.authorName}</a>
                                    </li>
                                </ul>
                                <div class="r right-info">
                                    <span class="looked">${blog.clickNum}浏览</span>
                                    <span class="recom">3推荐</span>
                                    <span class="judge">${blog.answerNum}评论</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
                </#if>
                <div class="row page">
                    <#if pageInfo.isFirstPage>
                    <span class="disabled_page">首页</span>
                    <span class="disabled_page" >上一页</span>
                    <#else>
                    <a href="/blog/${blogPage}/1">首页</a>
                    <a href="/blog/${blogPage}/${pageInfo.prePage}">上一页</a>
                    </#if>
                    <ul>
                        <#list pageInfo.navigateFirstPage..pageInfo.navigateLastPage as i>
                            <#if i == pageInfo.pageNum>
                            <li><a class="text-page-tag active" href="javascript:void(0)">${i}</a></li>
                            <#else >
                            <li><a class="text-page-tag" href="/blog/${blogPage}/${i}">${i}</a></li>
                            </#if>
                        </#list>
                    </ul>
                    <#if pageInfo.isLastPage>
                    <span class="disabled_page" >下一页</span>
                    <span class="disabled_page">尾页</span>
                    <#else >
                    <a href="${request.contextPath}/blog/${blogPage}/${pageInfo.nextPage}">下一页</a>
                    <a href="${request.contextPath}/blog/${blogPage}/${pageInfo.pages}">尾页</a>
                    </#if>
                </div>
            </div>
            <div class="col-lg-4 article-right r">
                <div class="new-ques">
                    <a href="/blog/save" class="write-ques">创建博客</a>
                    <div class="ques-wrap">
                        <div class="ques-info">
                            <a class="sharer-head" target="_blank" title>
                                <img src="//img2.mukewang.com/555e0b62000180e201000100-100-100.jpg" alt="" width="40" height="40">
                            </a>
                            <div class="right-uinfo">
                                <h3>
                                    <a href="#" target="_blank" title class="sharer-name">暴躁的黑猫警长 </a>
                                </h3>
                            </div>
                        </div>
                        <ul class="num-info">
                            <li>
                                <a href="#" target="_blank">
                                    博客
                                    <span>0</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    评论
                                    <span>0</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    推荐
                                    <span>0</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" target="_blank">
                                    收藏
                                    <span>0</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="other-article">
                    <h2>本月热门</h2>
                    <ul>
                        <li>
                            <a href="/article/21265" title="Java面试资源----百度&quot;Java面试题&quot;前200页大汇总" target="_blank"><h3>Java面试资源----百度"Java面试题"前200页大汇总</h3></a>
                            <div class="show-box clearfix">
                                <span class="spacer l">5442浏览</span>
                                <span class="spacer l spacer-2">38推荐</span>
                                <span class="spacer l" href="">5评论</span>
                            </div>
                        </li>
                        <li>
                            <a href="/article/21265" title="Java面试资源----百度&quot;Java面试题&quot;前200页大汇总" target="_blank"><h3>Java面试资源----百度"Java面试题"前200页大汇总</h3></a>
                            <div class="show-box clearfix">
                                <span class="spacer l">5442浏览</span>
                                <span class="spacer l spacer-2">38推荐</span>
                                <span class="spacer l" href="">5评论</span>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <#include "../footer.ftl">
    <script type="text/javascript" src="${request.contextPath}/static/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${request.contextPath}/static/js/bootstrap.min.js" ></script>
</body>
</html>