package com.xqtc.api.enums;

/**
 * PoIsDutyEnum.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
public enum PoIsDutyEnum {

    DUTY(0, "当值"),
    NOT_DUTY(1, "不当值"),
    ;

    private int code;
    private String message;

    private PoIsDutyEnum(int code, String msg) {
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
