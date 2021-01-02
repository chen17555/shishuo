<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <#include "../head.ftl">
<style>
.bbs {
    margin: 0 auto;
    -webkit-box-shadow: 0 2px 4px rgba(0,0,0,.2);
    -moz-box-shadow: 0 2px 4px rgba(0,0,0,.2);
    box-shadow: 0 2px 4px rgba(0,0,0,.2);
}
.sucesspage {
    background: #fff;
}
.sucesspage h2 {
    height: 59px;
    line-height: 59px;
    margin: 0 20px;
    border-bottom: 1px solid #d0d6d9;
    font-size: 18px;
}
.sendques {
    padding: 80px 0;
    text-align: center;
    color: #787d82;
}
.sendques span {
    background: url(/static/img/bbs.png) -1px -160px no-repeat;
    width: 120px;
    height: 120px;
    display: inline-block;
    margin-bottom: 10px;
}
.sendques h3 {
    font-size: 24px;
}
.sendques p {
    font-size: 14px;
}

.btn {
    margin-bottom: 0;
    font-weight: 200;
    text-align: center;
    vertical-align: middle;
    touch-action: manipulation;
    text-decoration: none;
    box-sizing: content-box;
    border: 1px solid transparent;
    -webkit-appearance: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

.btn-blue, .btn-green {
    -moz-transition: all .3s;
    color: #fff;
    border-style: solid;
    border-width: 1px;
    -weibkit-transition: all .3s;
    width: 138px;
    height: 38px;
    line-height: 38px;
    font-size: 14px;
}
.btn-green {
    background-color: #00b33b;
    border-color: #00b33b;
    cursor: pointer;
    transition: all .3s;
}
.sendques .btn {
    width: 160px;
    display: inline-block;
    margin: 20px 0 10px;
    padding: 0;
    border-radius: 0px;
}
.btn-green:link, .btn-green:visited {
    color: #fff;
}
    .main{
        padding-bottom: 180px;
    }
</style>
</head>
<body>
<#include "../nav.ftl">
<div class="container main">
    <div class="bbs clearfix">
        <div class="sucesspage">
            <h2>问题发布成功</h2>
            <div class="sendques">
                <span></span>
                <h3>您的问题已经提交成功!</h3>
                <p>请耐心等待，肯定会有很多热心的同学回答你的问题</p>
                <p>为鼓励好答案，请为他们投票并设置最佳答案（仅限提问）</p>
                <p><a href="${request.contextPath}/wenda" class="btn btn-green">返回猿问</a></p><p>
            </p><p>
                <a href="${request.contextPath}/wenda/detail/383638" class="myques">查看我提的问题</a>
            </p><p>
            </div>
        </div>
    </div>
</div>
<#include "../footer.ftl">
</body>
</html>