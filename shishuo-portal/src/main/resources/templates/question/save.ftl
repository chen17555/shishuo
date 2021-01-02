<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <#include "../head.ftl">
    <link rel="stylesheet" href="/static/css/question-save.css" />

    <script type="text/javascript" charset="utf-8" src="/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/static/ueditor/ueditor.all.min.js"></script>
</head>
<body>
<#include "../nav.ftl">
<div class="container main">
    <div class="row">
        <div class="col-lg-10 wenda-main">
            <div class="successpage">
                <h2 class="new-save-title">提问</h2>
                <div id="js-inputques" class="inputques">
                    <div class="quesdetail clearfix">
                        <span class="ques-label first-label">*</span>
                        <div class="question-area">
                            <input id="ques-title" type="text"  class="ipt autocomplete" maxlength="255" name='title' placeholder="请一句话说明你的问题，以问号结尾"/>
                            <p class="errortip"></p>
                        </div>
                    </div>
                    <div class="quesdetail mbottom">
                        <script id="editor" type="text/plain" ></script>
                        <p class="errortip"></p>
                    </div>
                    <div class="mbo">
                       <span class="ques-label">*</span>
                       <div class="new-tags ques-tag defaultbox">
                           <p class="new-tag-info">选择问题分类，最多可选3个</p>
                           <div id="js-tags" class="taglist clearfix">
                            <#if tags??>
                                <#list  tags as tag>
                                    <a href="javascrpit:;" class="save-list-tag" data-id="${tag.tagId}" name="${tag.tagName}">${tag.tagName}</a>
                                </#list>
                            </#if>
                           </div>
                       </div>
                    </div>
                    <div class="verify-box clearfix">
                        <span class="ques-label l">*</span>
                        <div class="verify-code">
                            <input type="text" maxlength="4" class="verify-code-ipt" placeholder="请输入验证码">
                            <a class="verify-img-wrap js-verify-refresh" hidefocus="true" href="javascript:void(0)">
                                <img id="randCodeImage" class="verify-img" src="/VerificationCode/generate" onclick="VerificationCode()"></a>
                            <a class="icon-refresh js-verify-refresh" hidefocus="true" href="javascript:void(0)"></a>
                            <span class="errtip"></span>
                        </div>
                    </div>
                    <div class="saveques-bottom">
                        <a href="javascript:;" id="ques-submit-btn" class="btn btn-red link-btn publishbtn">发布(Ctrl+Enter)</a>
                        <p class="global-errortip js-global-error"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../footer.ftl">
<script>
var ue = UE.getEditor('editor',{
    initialFrameHeight: 360,
});//初始化对象
function VerificationCode(){
    $("#randCodeImage").attr("src", "/VerificationCode/generate?rnd="+Math.random());
}
var question = {
    title:"",
    content:"",
    tags:"",
    tagnum:0
};
$('#js-tags a').click(function(){
    if($(this).hasClass("onactive")){
        question.tagnum = question.tagnum - 1;
        $(this).removeClass("onactive");
    }else if(question.tagnum < 3){
        question.tagnum = question.tagnum + 1;
        $(this).addClass("onactive");
    }
})
$("#ques-submit-btn").click(function(){
    question.tags = "";
    $("#js-tags").find("a.onactive").each(function(){
        question.tags = question.tags + $(this).data('id') + ",";
    });
    question.title = $("#ques-title").val();
    question.content = ue.getContent();
    $.ajax({
        url:'/wenda/savequestion',
        type:'POST',
        async:true,
        data:question,
        dataType:'json',
        success:function(data){
            if(data.code == 0){
                window.location.href = '/wenda/savesuccess';
            }
            console.log(data);
        },
        error:function(data){
            console.log(data);
        }
    })
})
</script>
</body>
</html>