package com.chenzhiheng.model;

import java.util.Date;

public class UserCollectQuestion extends UserCollectQuestionKey {
    private Date careteTime;

    private Date updataTime;

    public Date getCareteTime() {
        return careteTime;
    }

    public void setCareteTime(Date careteTime) {
        this.careteTime = careteTime;
    }

    public Date getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(Date updataTime) {
        this.updataTime = updataTime;
    }
}