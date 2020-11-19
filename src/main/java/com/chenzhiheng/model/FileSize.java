package com.chenzhiheng.model;

import java.util.Date;

public class FileSize {
    private Integer filesizeId;

    private Integer roleId;

    private Integer sizeLimit;

    private Date createTime;

    private Date updateTime;

    public Integer getFilesizeId() {
        return filesizeId;
    }

    public void setFilesizeId(Integer filesizeId) {
        this.filesizeId = filesizeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(Integer sizeLimit) {
        this.sizeLimit = sizeLimit;
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