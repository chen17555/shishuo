package com.czh.shishuo.admin.dto;

public class QuesetionSaveDto {

    private String title;

    private String content;

    private String tags;

    private String verifyCode;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "QuesetionSaveDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tags='" + tags + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
