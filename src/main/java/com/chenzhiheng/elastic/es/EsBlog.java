package com.chenzhiheng.elastic.es;


import java.io.Serializable;
import java.util.Date;

public class EsBlog implements Serializable{

    public Long blogId;

    private String title;

    private String contetn;

    private Date postTime;

    private Long clickCount;

    private Long answerCount;

    protected EsBlog(){}

    public EsBlog(String title, String contetn, Date postTime, Long clickCount, Long answerCount) {
        this.title = title;
        this.contetn = contetn;
        this.postTime = postTime;
        this.clickCount = clickCount;
        this.answerCount = answerCount;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContetn() {
        return contetn;
    }

    public void setContetn(String contetn) {
        this.contetn = contetn;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }

    @Override
    public String toString() {
        return "EsBlog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", contetn='" + contetn + '\'' +
                ", postTime=" + postTime +
                ", clickCount=" + clickCount +
                ", answerCount=" + answerCount +
                '}';
    }
}
