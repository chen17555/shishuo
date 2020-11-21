package com.czh.shishuo.dto;

public class UserLoginDto {

    private String userName;

    private String userPwd;

    private String verifyCode;

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
