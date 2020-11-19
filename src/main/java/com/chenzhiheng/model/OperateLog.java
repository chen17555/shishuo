package com.chenzhiheng.model;

public class OperateLog {
    private Integer optLogId;

    private Integer userId;

    private Integer operateId;

    private Integer operateType;

    public Integer getOptLogId() {
        return optLogId;
    }

    public void setOptLogId(Integer optLogId) {
        this.optLogId = optLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
}