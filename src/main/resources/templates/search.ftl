<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>搜索</title>
    <#include "head.ftl">
    <link rel="stylesheet" href="${request.contextPath}/static/css/search.css" />
</head>
<body>
<#include "nav.ftl">
<div id="main">
    <div class="search-main">
        <div class="search-header">
            <div class="search-form">
                <i class="icon icon-search sz-search"></i>
                <input type="text" class="search-form-ipt js-search-ipt" value="" placeholder="请输入想搜索的内容">
                <button class="search-form-btn js-search-btn">搜索</button>
                <div class="search-history-area js-search-history">
                </div>
            </div>
            <ul class="search-hot">
                <li><a href="/search/?words=AngularJS" target="_blank">AngularJS</a></li>
                <li><a href="/search/?words=mysql" target="_blank">mysql</a></li>
                <li><a href="/search/?words=java" target="_blank">java</a></li>
                <li><a href="/search/?words=android" target="_blank">android</a></li>
                <li><a href="/search/?words=C" target="_blank">C</a></li>
                <li><a href="/search/?words=php" target="_blank">php</a></li>
                <li><a href="/search/?words=javascript" target="_blank">javascript</a></li>
                <li><a href="/search/?words=ajax" target="_blank">ajax</a></li>
            </ul>
        </div>
        <div class="search-body">
            <div class="search-classify">
                <ul class="search-classify-list">
                    <li><a href="javascript:;" data-page="index" class="active">全站</a></li>
                    <li><a href="javascript:;" data-page="wenda">问答</a></li>
                    <li><a href="javascript:;" data-page="article">博客</a></li>
                </ul>
                <span class="search-related">共找到 0 个相关内容</span>
            </div>
            <div class="wenda-item">
                <div class="wenda-item-detail">
                    <img class="wenda-sign" src="//img.mukewang.com/563aff910001771f00900090-100-100.jpg">
                    <div class="wenda-detail-wrap">
                        <span class="wenda-detail-top">来自</span>
                        <span class="wenda-detail-top">Mysql</span>
                        <p class="wenda-detail-title">
                            <a href="/wenda/detail/1421" target="_blank"><span class="highlight">MySQL</span></a>
                        </p>
                        <span class="wenda-answer-total">共2个回答</span>
                        <div class="wenda-answer-wrap">
                            <a href="//www.imooc.com/u/5294867/bbs" target="_blank" class="wenda-answer-name">精慕门9254224</a>
                            <span class="wenda-answer">回答</span>
                            <p class="wenda-answer-content">net start MySQL</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="article-item">
                <a class="article-title" href="/blog/detail/1892" target="_blank">
                    <span class="highlight">MySQL</span> 基础之<span class="highlight">MySQL</span>简介
                </a>
                <div class="article-content ">
                    <p>
                        <span class="highlight">MySQL</span>基础 1.定义 开源的关系型数据库管理系统。现在被oracle收购。 2.安装 官网上下载有两种安装包： msi安装；初学者推荐； zip安装包。 3.配置<span class="highlight">MySQL</span> 1.<span class="highlight">MySQL</span>的配置文件路径： 安装目录下的<span class="highlight">MySQL</span>/<span class="highlight">MySQL</span> server/bin/mysqlinstanceconfig; 安装的时候将bin的子目录添加到环境变量配置中，这样就可以在任意目录下打开<span class="highlight">MySQL</span>命令。 4.<span class="highlight">MySQL</span>安装目录结构 1.bin目录：可执行文件； 2.data目录:存放数据文件； 3.docs目录：一些文档数据； 4.include目录：包含的头文件； 5.lib目录：
                        <a href="javascript:;" class="look">...</a>
                    </p>
                </div>
                <div class="article-foot">
							<span class="article-author article-create-time">
								2017-08-14			</span>
                    <span class="article-author">
								浏览 293			</span>
                    <span class="article-author">
								推荐 			</span>
                    <span class="article-author">
								评论 			</span>
                </div>
            </div>
            <p class="notedata">
                请在输入框输入想搜索的内容
            </p>
        </div>

    </div>
</div>
<#include "footer.ftl">
</body>
</html>