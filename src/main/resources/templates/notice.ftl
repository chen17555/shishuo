<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>通知</title>
    <#include "head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/notice.css" />
</head>
<body>
<#include "nav.ftl">
<div class="container main">
    <div id="notices" class="noticesPage">
        <div class="content">
            <div class="title-bar">
                <a class="l tip-setting" href="#">标题内容</a>
                <a class="r tag-read-btn" href="#">提交时间</a>
            </div>
            <div class="notice-list">
                <#list pageInfo.list as notice>
                    <div note-id="1959295" class="notice">
                        <div class="notice-box clearfix">
                            <div class="notice-show-box">
                                <p class="notice-con ">
                                    <a target="_blank" href="/notice/detail/${notice.noticeId}">${notice.noticeTitle}</a>
                                </p>
                                <h5 class="notice-date">${notice.createTime?date}</h5>
                            </div>
                            <div class="del-box clearfix">
                                <a href="javascript:void(0)" class="del-notice" title="删除此通知">
                                    <i class="icon icon-del"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
            <div class="row page">
                    <#if pageInfo.isFirstPage>
                    <span class="disabled_page">首页</span>
                    <span class="disabled_page" >上一页</span>
                    <#else>
                    <a href="/notice/1">首页</a>
                    <a href="/notice/${pageInfo.prePage}">上一页</a>
                    </#if>
                <ul>
                        <#list pageInfo.navigateFirstPage..pageInfo.navigateLastPage as i>
                            <#if i == pageInfo.pageNum>
                            <li><a class="text-page-tag active" href="javascript:void(0)">${i}</a></li>
                            <#else >
                            <li><a class="text-page-tag" href="/notice/${i}">${i}</a></li>
                            </#if>
                        </#list>
                </ul>
                    <#if pageInfo.isLastPage>
                    <span class="disabled_page" >下一页</span>
                    <span class="disabled_page">尾页</span>
                    <#else >
                    <a href="${request.contextPath}/notice/${pageInfo.nextPage}">下一页</a>
                    <a href="${request.contextPath}/notice/${pageInfo.pages}">尾页</a>
                    </#if>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftl">
</body>
</html>