package com.xqtc.api.enums;

/**
 * PoStateEnum.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
public enum PoStateEnum {

    DISABLED(0, "不可用"),
    ABLED(1, "可用"),
    AUTHSTR(2, "待审核"),
    ;

    private int code;
    private String message;

    private PoStateEnum(int code, String msg) {
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
