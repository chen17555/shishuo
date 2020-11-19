package com.chenzhiheng.model;

public class Keyman {
    private String tbName;

    private Integer primaryKey;

    public Keyman(String tbName) {
        this.tbName = tbName;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName == null ? null : tbName.trim();
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }
}