package com.chenzhiheng.enums;

public enum ReplyStatusEnum implements CodeEnum {
    ACTIVE(1,"正常"),
    DELETE(0,"删除");

    private Integer code;

    private String message;

    ReplyStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public Integer getCode() {
        return code;
    }
}
