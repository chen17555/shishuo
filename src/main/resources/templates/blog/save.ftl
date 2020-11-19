<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>校园问答平台</title>
    <#include "../head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/blog-save.css" />
    <link rel="stylesheet" href="/static/markdown/css/editormd.css" />
    <script type="text/javascript" src="/static/markdown/editormd.js" ></script>
</head>
<body>
<#include "../nav.ftl">
<div class="container main">
    <div class="article-wrap">
        <h2 class="article-title">发布手记</h2>
        <div class="article-form">
            <div class="form-group">
                <span class="needed">*</span>
                <div class="form-ipt-wrap">
                    <input type="text" id="art-title" class="art-title" placeholder="请在此输入标题，最多35中文字长度">
                </div>
            </div>
            <div class="form-group clearfix">
                <span class="needed">*</span>
                <div id="js-mk" class="mk-container"></div>
            </div>
            <div class="form-group tag-selector">
                <span class="needed">*</span>
                <div class="tag-selector-wrap">
                    <p class="tip">选择手记合适的标签，最多可选3个</p>
                    <div id="js-tags" class="tag-box clearfix" '="">
                    <#if tags??>
                        <#list tags as tag>
                            <span class="for-choice" data-id="${tag.tagId}">${tag.tagName}</span>
                        </#list>
                    </#if>
                </div>
                <p class="form-ipt-error"></p>
            </div>
        </div>
        <div class="form-group form-bottom">
            <div class="form-ipt-wrap">
                <button id="js-submit" class="btn btn-red">发布<span> (Ctrl+Enter)</span></button>
            </div>
        </div>
    </div>
</div>
</div>
<#include "../footer.ftl">
</body>
<script>
    var blogEditor;
    $(function() {
        blogEditor = editormd("js-mk", {
            width   : "100%",
            height  : 640,
            syncScrolling : "single",
            path    : "/static/markdown/lib/",
            saveHTMLToTextarea : true,
            toolbarIcons:function(){
                return [
                    "bold", "italic","link","quote", "image","code-block", "|",
                    "h1", "h2", "h3", "h4", "h5", "h6", "|",
                    "list-ol","list-ul","hr","|",
                    "undo", "redo", "||",
                    "watch", "fullscreen", "preview"]
            },
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "./php/upload.php?test=dfdf",
            onload:function(){
                blogEditor.setToolbarAutoFixed(false);
            }
        });
    });
    var blog = {
        title:"",
        content:"",
        tags:"",
        tagnum:0
    }
    $('#js-tags span').click(function(){
        if($(this).hasClass("onactive")){
            blog.tagnum = blog.tagnum - 1;
            $(this).removeClass("onactive");
        }else if(blog.tagnum < 3){
            blog.tagnum = blog.tagnum + 1;
            $(this).addClass("onactive");
        }
    })
    $("#js-submit").click(function () {
        blog.title = $("#art-title").val();
        blog.content = blogEditor.getMarkdown();
        blog.tags = "";
        $("#js-tags").find("span.onactive").each(function(){
            blog.tags = blog.tags + $(this).data('id') + ",";
        });

        $.ajax({
            url:'/blog/save',
            type:'POST',
            data:blog,
            dataType:'json',
            success:function (result){
                if(result.code == 0){
                    window.location.href = '/wenda/savesuccess';
                }
                console.log(result);
            },
            error:function (result){
                console.log(result);
            }
        })
    })
</script>
</html>