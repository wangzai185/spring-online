package com.xqtc.api.utils;

import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述: 返回状态码 如有需要 自行定义
 *
 * @auther: zhangw
 * @date: 2019/6/27 11:01
 */
public enum ResultCode {

    INVOKE_EXCEPTION(100, "exception occur:%s"),
    RESULT_IS_NULL(101, "result is null the id is:%s"),
    USERPHONE_OR_PASSWORD_IS_NULL(101, "userPhone or passWord is null the param is:%s"),
    SUCCESS(200, "sucessful"),
    CHECK_USER_FAIL(80000, "check user fail \'.\'"),
    PASSWORD_CHECK_FAIL(80001, "old password is error"),
    MUST_HAVE_ONE_POINT(80002, "menuToken must have one point"),
    TOKEN_IS_REPEAT(80003, "token is repeat"),
    ID_CANNOT_NULL(80004, "id is null"),
    CANNOT_ADD_BUSINESS(80005, "token不能重复!"),
    USER_IS_REPEAT(80006, "用户已存在!"),
    PRIVILEGE_REQUIRED(80007, "privilege required"),
    UPDATE_WHERE_CANNOT_NULL(80008, "更新操作时，条件不能为空"),
    VALIDATION_CODE_INVALID(80009, "验证码无效"),
    USER_EXIST(80009, "该用户已经注册"),
    UNKNOWN_USER_TYPE(80010, "未知用户类型"),
    PHONECODE_CANNOT_EMPTY(80011, "phoneCode不能为空"),
    PHONE_CANNOT_EMPTY(80012, "phone不能为空"),
    PASSWORD_CANNOT_EMPTY(80013, "password不能为空"),
    PHONETYPE_CANNOT_EMPTY(80014, "phonetype不能为空"),
    SOURCE_CANNOT_EMPTY(80015, "source不能为空"),
    PHONE_IS_NOT_SUPPORTED(80016, "手机格式不支持"),
    PASSWORD_AND_CODE_ISNULL(80017, "手机号验证码不能同时为空"),
    USER_IS_NOT_EXIST(80018, "用户不存在"),
    USER_NAME_PASSWORD_ERROR(80019, "用户名密码错误"),
    UNSUPPORTED_REQUEST_MODE(80020, "不支持的请求方式！"),
    TOKENFAILURE(80021, "token失效"),
    TOKENNULL(80022, "token不能为空"),
    ACCESSKEYNNULL(80023, "accessKey不能为空"),
    SIGNNNULL(80024, "sign不能为空"),
    ACCESSKEYUNSUPPORTED(80025, "accessKey不支持"),
    VALIDATION_FAILURE(80026, "验证不通过"),
    TIMESTAMPNULL(80026, "timestamp不能为空"),
    TIMESTAMP_INVALID(80027, "timestamp失效"),
    INSERT_ERR(80028, "入库失败"),
    INFORMATION_NON_EXISTENT(80029, "资讯不存在"),
    UPDATE_ERR(80030, "修改失败"),
    INFORMATION_ISNULL(80031, "资讯不存在"),
    DELET_ERR(80032, "删除失败");
    @ApiModelProperty(value = "状态码")
    private int code;
    @ApiModelProperty(value = "描述信息")
    private String message;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public static ResultCode valueOf(int code) {
        for (ResultCode value : values()) {
            if (code == value.code) {
                return value;
            }
        }

        return SUCCESS; // default is successful
    }

}