package com.czh.shishuo.enums;

public enum TableEnum {
    USER("user"),
    USER_INFO("user_info"),
    QUESTION("question"),
    QUESTION_REPLY("question_reply"),
    QUESTION_TAG("question_tag"),
    BLOG("blog"),
    BLOG_REPLY("blog_reply"),
    BLOG_TAG("blog_tag"),
    COLLEGE("college"),
    COLLEGE_REPORT("college_report"),
    COLLEGE_TAG("college_tag"),
    WORD_FILTER("word_fitler");

    String tableName;

    TableEnum(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
