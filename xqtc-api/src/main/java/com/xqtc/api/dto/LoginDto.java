package com.xqtc.api.dto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * LoginDto.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
@Data
@ApiModel
public class LoginDto implements Serializable {
    private static final long serialVersionUID = 2259970790536975884L;

    /**
     * 业主手机号
     */
    @ApiModelProperty(value = "业主手机号", required = true, example = "18552456191")
    @NotBlank(message = "业主手机号为空")
    @Pattern(regexp = "^((1[0-9]))\\d{9}$", message = "手机号格式错误")
    public String poPhone;
    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码", required = true, example = "e10adc3949ba59abbe56e057f20f883e")
    @NotBlank(message = "登录密码为空")
    public String poPassword;
    /**
     * 手机类型 1：安卓2：ios 3:  网站4：微信
     */
    @ApiModelProperty(value = "手机类型1：安卓2：ios 3:  网站4：微信", required = true ,example ="1" )
    @NotNull(message = "手机类型为空")
    private Integer poPhoneType;
}
