package com.xqtc.api.enums;

/**
 * IsChildEnum.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
public enum IsChildEnum {

    ACCOUNT(0, "主账号"),
    CHILD_ACCOUNT(1, "子账号"),
    ;


    private int code;
    private String message;

    private IsChildEnum(int code, String msg) {
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
