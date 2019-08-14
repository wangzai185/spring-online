package com.xqtc.api.enums;

/**
 * IsDeletedEnum.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
public enum IsDeletedEnum {

    NORMAL(0, "正常"),
    DELETED(1, "删除"),
    ;

    private int code;
    private String message;

    private IsDeletedEnum(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
