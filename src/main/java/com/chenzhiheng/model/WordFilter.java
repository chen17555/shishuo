package com.chenzhiheng.model;

import java.util.Date;

public class WordFilter {
    private Integer wordFilterId;

    private String keyWord;

    private Date createTime;

    public Integer getWordFilterId() {
        return wordFilterId;
    }

    public void setWordFilterId(Integer wordFilterId) {
        this.wordFilterId = wordFilterId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}