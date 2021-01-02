package com.czh.shishuo.model;

import java.util.Date;

public class College {
    private Integer collegeId;

    private String collegeName;

    private String collegeDesc;

    private Date createTime;

    private Date updateTime;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public String getCollegeDesc() {
        return collegeDesc;
    }

    public void setCollegeDesc(String collegeDesc) {
        this.collegeDesc = collegeDesc == null ? null : collegeDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}