<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>校园问答平台</title>
    <#include "../head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/blog-detail.css" />
    <script type="text/javascript" charset="utf-8" src="${request.contextPath}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${request.contextPath}/static/ueditor/ueditor.all.min.js"></script>
    <#include "../markdown_nav.ftl">
</head>
<body>
<#include "../nav.ftl">

<div class="top-bg-warp">
    <div class="container">
        <div class="top-bg clearfix">
            <div class="top-bg-left l">
                <div class="detail-path">
                    <a href="/article">博客</a> \ <span>${blog.blogTitle}</span>
                </div>
                <div class="detail-title-wrap">
                    <h1 class="detail-title">
                        <span class="d-t">${blog.blogTitle}</span>
                    </h1>
                    <div class="dc-addon clearfix">
                        <div class="dc-profile clearfix">
                            <span class="spacer l">12小时前</span>
                            <span class="spacer l spacer-2">${blog.clickNum}浏览</span>
                            <a class="spacer l" href="#comment">${blog.answerNum}评论</a>
                            <div class="r rinfo">
                                <div class="font-info">
                                    <a class="font-warp">
                                        <span class="size-show">小字号</span>
                                        <span class="op-icon icon-drop_down"></span>
                                        <ul class="hide font-box-s clearfix">
                                            <li data-size-f="big-size-f" class="b-z">大字</li>
                                            <li data-size-f="md-size-f" class="m-z">中字</li>
                                            <li data-size-f="sm-size-f" class="s-z">小字</li>
                                        </ul>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container main">
    <div class="col-lg-8 opus-wrap">
        <div class="detail-left l">
            <div class="detail-content-wrap">
                <div class="sm-size-f">
                    <div id="doc-content">
                        <textarea style="display:none;">${blog.blogContent }</textarea>
                    </div>
                </div>
                <div class="cat-box">
                    <div class="cat-wrap clearfix">
                        <span class="l ori-span">相关标签：</span>

                        <a class="cat l" href="/article/tag/3" target="_blank">JAVA</a>
                    </div>
                </div>
                <div class="praise-box">
                    <button id="js-praise" class=""><span class="icon  icon-good" style="color: rgb(183, 187, 191); transform: scale3d(1, 1, 1);"></span>
                </div>
            </div>
            <div class="detail-feedback-wrap" style="display: none">
                <div class="df-ipt-wrap" id="comment">
                    <h4 class="add-com-tip">添加评论</h4>
                    <div class="feeds-author">
                        <img src="//img3.mukewang.com/user/54584f540001558402200220-80-80.jpg" alt="慕粉3848047">
                    </div>
                    <div class="df-text">
                        <div id="js-reply-editor-box"></div>
                        <p id="feed-error" class="feed-error"></p>
                        <div class="df-bottom clearfix">
                            <div class="verify-code"></div>
                            <button id="js-submit" class="btn btn-green r">评论（Ctrl+Enter）</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../footer.ftl">
</body>
<script type="text/javascript">
    var testEditor;
    $(function () {
        testEditor = editormd.markdownToHTML("doc-content", {//注意：这里是上面DIV的id
            htmlDecode: "style,script,iframe",
            emoji: true,
            taskList: true,
            tex: true, // 默认不解析
            flowChart: true, // 默认不解析
            sequenceDiagram: true, // 默认不解析
            codeFold: true,
        });});
</script>
</html>