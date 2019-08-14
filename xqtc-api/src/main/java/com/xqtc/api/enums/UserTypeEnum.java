package com.xqtc.api.enums;

/**
 * UserTypeEnum.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
public enum UserTypeEnum {

    CAR_OWNER(0, "车主"),
    PROPRIETOR(1, "业主"),
    ;

    private int code;
    private String message;

    private UserTypeEnum(int code, String msg) {
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
