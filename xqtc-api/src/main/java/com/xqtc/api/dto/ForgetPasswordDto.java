package com.xqtc.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Data
public class ForgetPasswordDto {
    /**
     * 手机验证码
     */
    @ApiModelProperty(value = "手机验证码", required = true, example = "123456")
    @NotBlank(message = "验证码为空")
    @Length(max = 6, message = "验证码过长")
    private String code;


    /**
     * 业主手机号
     */
    @ApiModelProperty(value = "业主手机号", required = true, example = "18552456191")
    @NotBlank(message = "业主手机号为空")
    @Pattern(regexp = "^((1[0-9]))\\d{9}$", message = "手机号格式错误")
    private String poPhone;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码", required = true, example = "e10adc3949ba59abbe56e057f20f883e")
    @NotBlank(message = "登录密码为空")
//    @Length(min = 6, max = 10, message = "用户密码长度必须在6-10之间")
    private String poPassword;

}
