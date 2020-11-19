<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${user.userNickname}的个人主页</title>
    <#include "../head.ftl">
    <script src="${request.contextPath}/static/js/vue.js"></script>
    <link rel="stylesheet" href="${request.contextPath}/static/css/user.css" />
</head>
<body>
<#include "../nav.ftl">
<div id="main">
    <div class="bg-other user-head-info">
        <div class="user-info">
            <h3 class="user-name clearfix">
                <span>${user.userNickname}</span>
            </h3>
            <p class="about-info">
                <span class="sexSecret" title=""></span>
                学生
                <span class="u-tiwen"></span>
                <span class="u-tiwen"></span>
                <span class="u-tiwen"></span>
            </p>
            <p class="user-desc" title="${user.userDesc}">${user.userDesc}</p>
            <div class="study-info">
                <div class="item follows">
                    <a href="#"><em>1</em></a>
                    <span>关注</span>
                </div>
                <div class="item followers">
                    <a href="/u/#{user.userId}/fans"><em>1</em></a>
                    <span>粉丝</span>
                </div>
            </div>
        </div>
    </div>
    <div class="container main">
        <div class="wrap">
            <div class="slider">
                <div class="user-pic">
                    <div class="user-pic-bg"></div>
                    <img class="img" src="/${user.userAvatar}" alt="">
                </div>
                <ul>
                    <li>
                        <a href="/u/#{user.userId}">
                            <i class="glyphicon glyphicon-home"></i>
                            <span>主页</span>
                        </a>
                    </li>
                    <li>
                        <a href="/u/#{user.userId}/question">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>问答</span>
                        </a>
                    </li>
                    <li>
                        <a href="/u/#{user.userId}/blog">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>博客</span>
                        </a>
                    </li>
                    <#if user??>
                    <li>
                        <a href="/u/#{user.userId}/history">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>历史</span>
                        </a>
                    </li>
                    </#if>
                    <#if user??>
                    <li>
                        <a href="/u/#{user.userId}/setting" class="active">
                            <i class="glyphicon glyphicon-question-sign"></i>
                            <span>设置</span>
                        </a>
                    </li>
                    </#if>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div id="u-container" class="u-container">
                <div class="article-main">
                    <ul class="clearfix toptab">
                        <li class="" v-bind:class="{tabactive: isInfo}"><a href="/u/#{user.userId}/setting?area=info">编辑资料</a></li>
                        <li class="" v-bind:class="{tabactive: isAuth}"><a href="/u/#{user.userId}/setting?area=verify">老师认证</a></li>
                    </ul>
                    <div class="list-item article-item">
                        <form class="form-horizontal" style="width: 430px;">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">昵称：</label>
                                <div class="col-sm-8">
                                    <input class="form-control" value="${user.userNickname}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">邮箱地址：</label>
                                <div class="col-sm-8">
                                    <input class="form-control" value="${user.userEmail}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">手机号：</label>
                                <div class="col-sm-8">
                                    <input class="form-control" value="${user.userPhone}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">性别：</label>
                                <div class="col-sm-8">

                                    <#if user.userSex?? && user.userSex>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex1" value="option1"> 保密
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex2" value="option2" checked="checked"> 男
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex3" value="option3"> 女
                                        </label>
                                    <#elseif  !user.userSex>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex1" value="option1"> 保密
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex2" value="option2" > 男
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex3" value="option3" checked="checked"> 女
                                        </label>
                                    <#else >
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex1" value="option1" checked="checked"> 保密
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex2" value="option2" > 男
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="sex" id="sex3" value="option3" > 女
                                        </label>
                                    </#if>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">个性签名：</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" rows="3" >${user.userDesc}</textarea>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">保存个人资料</button>
                        </form>
                        <form class="form-horizontal" style="display: none">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">真实姓名：</label>
                                <div class="col-sm-8">
                                    <input class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">身份证号码：</label>
                                <div class="col-sm-8">
                                    <input class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">身份证照片：</label>
                                <div class="col-sm-8">
                                    <div class="l auth-photo">
                                        <i class="icon-plus b"></i>
                                        <p>上传身份证正面照片</p>
                                        <img class="imgfb img-f" src="">
                                        <input type="file" name="fileField" id="img_a" class="upload" data-flag="a">
                                        <input type="hidden" name="key-font" class="js-key js-font">
                                    </div>
                                    <div class="r auth-photo">
                                        <i class="icon-plus b"></i>
                                        <p>上传身份证反面照片</p>
                                        <img class="imgfb img-f" src="">
                                        <input type="file" name="fileField" id="img_b" class="upload" data-flag="a">
                                        <input type="hidden" name="key-back" class="js-key js-font">
                                    </div>
                                </div>
                                <div class="col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary">提交审核</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../footer.ftl">
</body>
<script>
    var vue = new Vue({
        el:"#u-container",
        data:{
            tabs:["编辑资料","老师认证"],
            tabContents:["11","22","33"],
            num:1
        },
        methods:{
            tab:function(index){
                this.num = index;
            }
        }
    })
</script>
</html>