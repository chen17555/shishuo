package com.chenzhiheng.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlFilter {
    public static String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式

    public static String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式

    public static String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

    public static String REHtml(String content){
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(content);
        content=m_html.replaceAll("");
        return content;
    }
}
