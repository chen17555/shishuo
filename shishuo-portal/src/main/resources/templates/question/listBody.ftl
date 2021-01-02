<div class="row wenda-list">
    <#if pageInfo?exists>
        <#list pageInfo.list as question>
            <div class="ques-answer">
                <div class="tag-img">
                    <a href="#" target="_blank">
                        <img src="${request.contextPath}${question.questionTagImg!}" />
                    </a>
                </div>
                <div class="from-tag">
                    来自
                    <#if question.questionTags ??>
                        <#list question.questionTags?split(",") as tag>
                            <a href="#" target="_blank">${tag}</a>
                        </#list>
                    </#if>
                </div>
                <div class="ques-con">
                    <a href="${request.contextPath}/wenda/detail/${question.questionId?c}" class="ques-con-content" target="_blank" title="6666">${question.questionTitle}</a>
                </div>
                <div class="info-bar clearfix">
                    <a href="${request.contextPath}/wenda/detail/${question.questionId?c}" class="to-answer">撰写答案</a>
                    <p class="integral-info"><a>这位大侠发表一下评论吧！</a></p>
                    <a href="${request.contextPath}/wenda/detail/${question.questionId?c}" class="answer-num">${question.answerNum}个回答</a>
                    <a href="javascript:;" class="follow" data-ques-id="${question.questionId?c}">
                        <i class="heart">关注</i>
                    </a>
                </div>
            </div>
        </#list>
    </#if>
</div>