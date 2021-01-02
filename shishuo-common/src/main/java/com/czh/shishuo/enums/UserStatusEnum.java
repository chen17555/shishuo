package com.czh.shishuo.enums;

public enum UserStatusEnum implements CodeEnum {
    FREEZE(0, "冻结"),
    ACTIV(1, "活跃"),
    ;

    private Integer code;

    private String message;


    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }
}
