<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${question.questionTitle}</title>
    <#include "../head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/question-detail.css" />
</head>
<style>
    .tipoff-box {
        padding: 24px 32px 32px;
        width: 450px;
        height: 336px;
        background: #FFF;
        box-shadow: 0 8px 16px 0 rgba(7,17,27,.2);
        border-radius: 8px;
        box-sizing: border-box;
        z-index: 100;
    }
    .tipoff-box .tipoff-top-box {
        margin-bottom: 24px;
        width: 100%;
        font-size: 16px;
        color: #07111B;
        line-height: 24px;
    }
    .tipoff-box .tipoff-top-box .tipoff-close-btn {
        font-size: 24px;
        color: #93999F;
        line-height: 24px;
    }
    .tipoff-box .tipoff-type-box {
        width: 100%;
        height: 58px;
        overflow: hidden;
        margin-bottom: 24px;
    }
    .tipoff-box .tipoff-loading {
        margin: 10px auto;
        width: 70px;
        z-index: 6;
    }
    .tipoff-box .tipoff-type-box .item {
        width: 33.3%;
        font-size: 12px;
        color: #93999F;
        line-height: 24px;
        overflow: hidden;
    }
    .tipoff-box .tipoff-type-box .item i {
        display: inline-block;
        margin-right: 4px;
        font-size: 16px;
        line-height: 24px;
    }
    .tipoff-box .tipoff-type-box .item p {
        max-width: 108px;
        height: 24px;
        overflow: hidden;
    }
    .tipoff-box .tipoff-content {
        position: relative;
    }
    .tipoff-box .tipoff-content .tipoff-desc {
        padding: 12px;
        width: 386px;
        height: 88px;
        background: #FFF;
        border: 1px solid #D9DDE1;
        border-radius: 2px;
        box-sizing: border-box;
        font-size: 14px;
        color: #07111B;
        resize: none;
    }
    .tipoff-box .tipoff-content .tipoff-text {
        position: absolute;
        bottom: 12px;
        right: 12px;
        font-size: 12px;
        color: #93999F;
        line-height: 12px;
    }
    .tipoff-box .tipoff-btn-box {
        width: 100%;
        margin-top: 24px;
    }
    .tipoff-box .tipoff-btn-box .tipoff-submit-btn {
        width: 76px;
        height: 36px;
        background: rgba(240,20,20,.8);
        border-radius: 2px;
        font-size: 14px;
        color: #FFF;
        line-height: 36px;
        text-align: center;
        cursor: pointer;
    }
    .tipoff-box .tipoff-btn-box .tipoff-cancel-btn {
        margin-right: 8px;
        width: 76px;
        height: 36px;
        line-height: 36px;
        border: 1px solid #D9DDE1;
        border-radius: 2px;
        font-size: 14px;
        color: #93999F;
        text-align: center;
        cursor: pointer;
    }
</style>
<body>
<#include "../nav.ftl">
<div class="container main">
    <div class="row wenda">
        <div class="col-lg-8 wenda-main">
            <div class="qa-content">
                <div class="js-content-main">
                    <div class="detail-q-title clearfix">
                        <h1 class="detail-wenda-title">${question.questionTitle}</h1>
                        <div class="wenda-intro-box clearfix">
                            <div class="detail-user l">
                                <a href="/u/#{question.authorId}" class="author l">
                                    <img src="/${question.authorAvatar}" alt="${question.authorName}">
                                    ${question.authorName}
                                </a>
                            </div>
                            <div class="wenda-edit-box r">
                                <a id="ques-report" href="javascript:;" data-quesid="${question.questionId?c}" data-type="1" data-uid="${question.authorId?c}" class="js-tip-off detail-edit l" data-toggle="modal" data-target="#reportBox">举报</a>
                                <span class="count-item l">回答<i>${question.answerNum?c}</i></span>
                                <span class="count-item l">浏览<i>${question.clickNum?c}</i></span>
                            </div>
                        </div>
                    </div>
                    <div class="detail-wenda">
                        ${question.questionContent}
                    </div>
                </div>
            </div>
            <div class="detail-comment-input clearfix">
                <h3 class="answer-add-tip">添加回答</h3>
                <div id="add-answer" class="detail-ci-avator">
                    <button id="answer-frame" class="answer-btn"></button>
                </div>
                <div id="avator-wrap" class="detail-ci-avator answer-hidden l">
                    <#if user??>
                    <img src="/${user.userAvatar}" alt="">
                    </#if>
                </div>
                <div id="js-reply-wrap" class="answer-hidden l">
                    <div id="js-reply-editor-box" class="wd-comment-box js-ci-inner ">
                    </div>
                    <div id="js-qa-ci-footer" class="qa-ci-footer clearfix">
                        <span class="qa-tips l"></span>
                        <div class="qa-ci-footright">
                            <button id="js-wenda-ci-submit" class="btn btn-red detail-ans " data-qid="${question.questionId?c}">回答</button>
                        </div>
                    </div>
                </div>
            </div>
            <#if question.answerNum != 0>
                <div class="ans_num">${question.answerNum}回答</div>
            <#else >
                <div class="none_ans">暂无任何回答</div>
            </#if>
            <#if question.replyList??>
            <#list question.replyList as reply>
                <div class="ques-answer ques-new-answer clearfix">
                    <div class="edit-title">编辑回答</div>
                    <div class="answer-con first" id='${reply.qustReplyId?c}' data-reply-id="#{reply.qustReplyId}">
                        <div class="user-pic l">
                            <a href="/u/#{reply.userId}">
                                <img src="/${reply.userAvatar}" width="40" height="40" alt="?" />
                            </a>
                        </div>
                        <div class="detail-r">
                            <#if reply.userId == question.authorId>
                            <span class="detail-provider">提问者</span>
                            </#if>
                            <a class="detail-name" href="/u/#{reply.userId}/bbs" target="_blank">${reply.userNickName}</a>
                        </div>
                        <div class="answer-content rich-text aimgPreview">
                            ${reply.repleyContent}
                        </div>
                        <div class="ctrl-bar js-msg-context clearfix js-reply-tool hide">
                            <div class="detail-editor-btns r">
                                <span class="qa-tips"></span>
                                <button class="btn btn-normal js-reply-cancel"></button>
                                <button class="btn btn-red js-reply-submit" data-id="270733">保存</button>
                            </div>
                        </div>
                        <div class="ctrl-bar clearfix js-wenda-tool">
                                    <span class="agree-with " data-ques-id="383576" data-answer-id="270733" data-hasop="">
                                        <i class="icon icon-good"></i>
                                    </span>
                            <span class="oppose " data-ques-id="383576" data-answer-id="270733" data-hasop="">
                                        <i class="icon icon-bad"></i><em>反对</em>
                                    </span>
                            <span class="reply" data-replynum="0" data-reply-id="270733" data-ques-uid="5468417"><em>#{reply.replyNum}</em>个回复</span>
                            <a href="javascript:;" data-quesid="${question.questionId?c}" data-answerid="${reply.qustReplyId?c}" data-type="2" data-uid="${reply.userId?c}" class="reply-del js-tip-off" data-toggle="modal" data-target="#reportBox">举报</a>
                            <span class="time r">${reply.repleyTime?date}</span>
                        </div>
                    </div>
                    <div class="reply-con">
                        <ul class="reply-list">
                            <#--<li class="clearfix">
                                <div class="user-pic">
                                    <a href="/u/355865/bbs" target="_blank">
                                        <img src="//img.mukewang.com/user/545845c40001996c02200220-40-40.jpg" alt="erutdioup8556">
                                    </a>
                                </div>
                                <div class="user-info clearfix">
                                    <#if reply.userId == question.authorId>
                                        <em>提问者</em>
                                    </#if>
                                    <a class="from-user" href="/u/355865/bbs">erutdioup8556</a>
                                    <span class="r floor">#1</span>
                                </div>
                                <div class="reply-content">嗯嗯嗯嗯</div>
                                <div class="reply-btn l" data-uid="355865" data-username="erutdioup8556">回复</div>
                                <a href="javascript:void(0)" data-uid="355865" data-type="3" data-id="50629" class="reply-del js-tip-off">举报</a>
                                <span class="time r">2017-05-23 21:21:35</span>
                            </li>-->
                        </ul>
                        <div class="release-reply-con clearfix">
                            <#if user??>
                            <div class="user-pic ">
                                <a href="/u/1980527/bbs" target="_blank">
                                    <img src="/${user.userAvatar}" width="40" height="40" alt="?">
                                </a>
                            </div>
                            <div class="textarea-con">
                                <textarea name="release-reply" id="release-reply" placeholder="写下你的回复" touser="回复 erutdioup8556："></textarea>
                            </div>
                            <p class="err-tip"></p>
                            <div class="userCtrl clearfix">
                                <div class="verify-code"></div>
                                <div class="do-reply-btn" data-answer-id="#{reply.qustReplyId}" data-ques-id="#{question.questionId}" data-ques-uid="#{question.authorId}">回复</div>
                            </div>
                            <#else>
                                <span>你还没有登录，请先登录或注册慕课网帐号</span>
                            </#if>
                        </div>
                    </div>
                </div>
            </#list>
            </#if>
        </div>
        <div class="col-lg-4 wenda-slider">
        </div>
    </div>
</div>
<#include "../footer.ftl">
<div class="modal ss-model in" id="reportBox">
    <div class="tipoff-box js-tipoff-box">
        <div class="tipoff-top-box clearfix">
            <p class="l tipoff-title">举报</p>
            <span class="r tipoff-close-btn icon-close2 js-tipoff-close"></span>
        </div>
        <div class="tipoff-type-box js-tipoff-typebox clearfix">
            <div class="tipoff-loading">
                <div class="bounce1"></div>
                <div class="bounce2"></div>
                <div class="bounce3"></div>
            </div>
            <#list reportType as type>
                <div class="item l">
                    <i class="l icon icon-square" data-type="${type.reportTypeId}"></i>
                    <p class="l">${type.reportTypeName}</p>
                </div>
            </#list>
        </div>
        <div class="tipoff-content">
            <textarea name="tipoff-content" class="tipoff-desc js-tipoff-desc" placeholder="写下举报理由"></textarea>
            <div class="tipoff-text"><span class="js-tipoff-text">0</span>/150</div>
        </div>
        <div class="tipoff-btn-box clearfix">
            <div id="tip-submit-btn" class="r tipoff-submit-btn js-tipoff-submit" data-tipofftype="">提交</div>
            <div class="r tipoff-cancel-btn js-tipoff-close" data-dismiss="modal">取消</div>
        </div>
    </div>
</div>
</body>
    <script type="text/javascript" charset="utf-8" src="${request.contextPath}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${request.contextPath}/static/ueditor/ueditor.all.min.js"></script>
    <script>
        $(function () {
            var id=window.location.href.split("#")[1];
            var i = 0;
            var interval = setInterval(function(){
                $("#"+id).fadeOut(120).fadeIn(120);
                i++;
                if(i >= 8){
                    clearInterval(interval);
                }
            },500);
        })
        $(function(){
            var nowTitle = $("title").html();
            var nowUrl = document.URL;
            var nowType = 1;
            var history;
            var json = "[";
            var json1;
            var canAdd= true;
            if(!$.cookie("history")){
                history = $.cookie("history","{title:\""+nowTitle+"\""+",url:\""+nowUrl+"\""+",type:\""+nowType+"\"}", { expires: 30 });
            }else {
                history = $.cookie("history");
                json1 = eval("("+history+")");
                $(json1).each(function(){
                    if(this.title==nowTitle){
                        canAdd=false;
                        return false;
                    }
                })
                if(canAdd){
                    $(json1).each(function(){
                        json = json + "{\"title\":\""+this.title+"\",\"url\":\""+this.url+"\"},";
                    })
                    json = json + "{\"title\":\""+nowTitle+"\",\"url\":\""+nowUrl+"\"}]";
                    $.cookie("history",json,{expires:30});
                }
            }
        })
        $(".do-reply-btn").on("click",function(event){
            var reply = {
                parentId:$(event.target).data("answer-id"),
                questionId:$(event.target).data("ques-id"),
                content:$(event.target).parents(".release-reply-con").find("#release-reply").val()
            }
            $.ajax({
                url:"/wenda/savereply",
                type:"post",
                data:reply,
                dataType:"json",
                success:function(data){
                    if(data.code == 0){
                        console.log("succe");
                        location.reload();
                    }
                },
                error:function(data){
                    console.log(data);
                }
            })
        })
        $("#ques-report").click(function(){
            $("#tip-submit-btn").data("type",$(this).data("type"));
            $("#tip-submit-btn").data("uid",$(this).data("uid"));
            $("#tip-submit-btn").data("quesid",$(this).data("quesid"));
        })
        $(".js-wenda-tool .reply").click(function(){
            if($(this).parents(".answer-con").next().css("display") == "block"){
                $(this).parents(".answer-con").next().css("display","none");
            }else{
                $(this).parents(".answer-con").next().css("display","block");
            }
            var temp = $(this);
            $.ajax({
                url:"/wenda/getreplys",
                type:"post",
                data:{"replyId":temp.parents(".ques-answer").find(".answer-con").data("reply-id")},
                dataType:"json",
                success:function(data){
                    for(i in data.data){
                        var relpy = "<li class=\"clearfix\">\n" +
                            "            <div class=\"user-pic\">\n" +
                            "                <a href=\"/u/"+data.data[i].userId+"/qeustion\" target=\"_blank\">\n" +
                            "                    <img src=\"/"+data.data[i].userAvatar+"\" alt=\""+data.data[i].userNickName+"\">\n" +
                            "                </a>\n" +
                            "            </div>\n" +
                            "            <div class=\"user-info clearfix\">\n" +
                            "                <a class=\"from-user\" href=\"/u/"+data.data[i].userId+"/question\">"+data.data[i].userNickName+"</a>\n" +
                            "                <span class=\"r floor\">#"+i+"</span>\n" +
                            "            </div>\n" +
                            "            <div class=\"reply-content\">"+data.data[i].repleyContent+"</div>\n" +
                            "            <div class=\"reply-btn l\" data-uid=\""+data.data[i].userId+"\" data-username=\""+data.data[i].userNickName+"\">回复</div>\n" +
                            "            <a href=\"javascript:void(0)\" data-uid=\"355865\" data-type=\"3\" data-id=\"50629\" class=\"reply-del js-tip-off\">举报</a>\n" +
                            "            <span class=\"time r\">"+data.data[i].repleyTime+"</span>\n" +
                            "        </li>";
                        temp.parents(".ques-answer ").find(".reply-con .reply-list").append(relpy);
                    }
                },
                error:function(){
                    console.log("服务器异常");
                }
            })
        })
        $(".js-wenda-tool .reply-del").click(function(){
            $("#tip-submit-btn").data("type",$(this).data("type"));
            $("#tip-submit-btn").data("uid",$(this).data("uid"));
            $("#tip-submit-btn").data("answerid",$(this).data("answerid"));
            $("#tip-submit-btn").data("quesid",$(this).data("quesid"));
        })
        $("#reportBox .item .icon").click(function(){
            if($(this).hasClass("icon-square")){
                $(this).removeClass("icon-square");
                $(this).addClass("icon-squarecheckfill");
            }else{
                $(this).removeClass("icon-squarecheckfill");
                $(this).addClass("icon-square");
            }
        })
        $("#tip-submit-btn").click(function(){
            var report = {
                reportedId:"",
                reportedUserId:"",
                reportedReplyId:"",
                reportedType:"",
                reportDesc:"",
                types:""
            }
            $("#reportBox").find("i.icon-squarecheckfill").each(function(){
                report.types = report.types + ($(this).data("type")) + ",";
            })
            report.reportedId = $(this).data("quesid");
            report.reportedUserId = $(this).data("uid");
            if($(this).data("answerid") != null && $(this).data("answerid") != ""){
                report.reportedReplyId = $(this).data("answerid");
            }
            report.reportedType = $(this).data("type");
            report.reportDesc = $("#reportBox textarea").val();
            $.ajax({
                url:"/report",
                type:"post",
                data:report,
                dataType:"json",
                success:function(result){
                    if(result.code == 0){
                        alert("发送成功");
                        $("#reportBox").modal("hide");
                    }
                }
            })
        })

        $("#answer-frame").click(function(){
            <#if user??>
                editor = UE.getEditor('js-reply-editor-box',{
                        initialFrameWidth : 560,
                        initialFrameHeight: 170,
                    });
                $("#answer-frame").addClass("answer-hidden");
                $("#avator-wrap").removeClass("answer-hidden");
                $("#js-reply-wrap").removeClass("answer-hidden");
            <#else >
                $("body").append(signinTpl);
                $("#signin").modal('show');
            </#if>
        })
        $("#js-wenda-ci-submit").click(function(){
            var repley = {
                content:editor.getContent(),
                questionId:$(this).data('qid')
            }
            $.ajax({
                url:'/wenda/savereply',
                type:'POST',
                data:repley,
                dataType:'json',
                success:function(data){
                    if(data.code == 0){
                        console.log("succe");
                        location.reload();
                    }
                },
                error:function(data){
                    console.log(data);
                }
            })
        })
    </script>
</html>
