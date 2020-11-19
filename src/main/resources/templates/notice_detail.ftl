<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${notice.noticeTitle}</title>
<#include "head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/notice.css" />
    <#include "markdown_nav.ftl">
</head>
<body>
<#include "nav.ftl">
<div class="container main">
    <div class="detail-title text-center">
        <h4 bo-html="vm.message.Title">${notice.noticeTitle}</h4>
        <div bo-text="vm.message.GmtCreated|date:'yyyy-MM-dd HH:mm:ss'">${notice.createTime?date}</div>
    </div>
    <div class="detail-content breakall">
        <div class="console-title-border margin-top-2"></div>
        <div class="margin-top-2 ng-binding" >
            <div id="doc-content">
                <textarea style="display:none;">${notice.noticeContent}</textarea>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftl">
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