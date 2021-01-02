package com.czh.shishuo.model;

import java.util.Date;

public class Report {
    private Integer reportId;

    private Integer reportedId;

    private Integer reportedUserId;

    private Integer reportedReplyId;

    private Integer reportedType;

    private String reportDesc;

    private Integer complainUserId;

    private Date createTime;

    private Date updateTime;

    private Integer reportStatus;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getReportedId() {
        return reportedId;
    }

    public void setReportedId(Integer reportedId) {
        this.reportedId = reportedId;
    }

    public Integer getReportedUserId() {
        return reportedUserId;
    }

    public void setReportedUserId(Integer reportedUserId) {
        this.reportedUserId = reportedUserId;
    }

    public Integer getReportedReplyId() {
        return reportedReplyId;
    }

    public void setReportedReplyId(Integer reportedReplyId) {
        this.reportedReplyId = reportedReplyId;
    }

    public Integer getReportedType() {
        return reportedType;
    }

    public void setReportedType(Integer reportedType) {
        this.reportedType = reportedType;
    }

    public String getReportDesc() {
        return reportDesc;
    }

    public void setReportDesc(String reportDesc) {
        this.reportDesc = reportDesc == null ? null : reportDesc.trim();
    }

    public Integer getComplainUserId() {
        return complainUserId;
    }

    public void setComplainUserId(Integer complainUserId) {
        this.complainUserId = complainUserId;
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

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }
}