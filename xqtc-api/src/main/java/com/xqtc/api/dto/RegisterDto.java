package com.xqtc.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * RegisterDto.class
 *
 * @author HangLin.Ren
 * @date 2019/07/19
 */
@Data
@ApiModel
public class RegisterDto implements Serializable {

    private static final long serialVersionUID = -1234544737630642453L;

    /**
     * 手机验证码
     */
    @ApiModelProperty(value = "手机验证码", required = true, example = "123456")   //必填
//    @NotBlank(message = "验证码为空")
//    @Length(max = 6, message = "验证码过长")
    private String msgCode;
    /**
     * 业主手机号
     */
    @ApiModelProperty(value = "业主手机号", required = true, example = "18552456191")  //必填
//    @NotBlank(message = "业主手机号为空")
//    @Pattern(regexp = "^((1[0-9]))\\d{9}$", message = "手机号格式错误")
    private String poAccount;
    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码", required = true, example = "123456")   //必填
//    @NotBlank(message = "登录密码为空")
//    @Length(min = 6, max = 20, message = "用户密码长度必须在6-20之间")
    private String poPassword;
    /**
     * 手机类型 1：安卓2：ios 3:  网站4：微信
     */
    @ApiModelProperty(value = "手机类型1：安卓2：ios 3:  网站4：微信", required = true, example = "1")
//    @NotNull(message = "手机类型为空")
    private Integer poPhoneType;

    /**
     * 渠道id
     */
    @ApiModelProperty(value = "渠道id (1：安卓2：ios 3:  网站4：微信)")    //必填 1：安卓2：ios 3:  网站4：微信
    private Integer poChannelId;

    /**
     * 是否为子账号:0:子账号 1:主账号
     */
    @ApiModelProperty(value = "是否为子账号 0是 1否", required = true, example = "1")   //必填
    private Integer poIsChild;

    /**
     * 子账号的权限设置
     */
    @ApiModelProperty(value = "子账号的权限设置(注册时不必传,添加子账号时必传)", required = false, example = "")
    private String childOauthId;

    /**
     * 父账号id
     */
    @ApiModelProperty(value = "父账号id(注册时不必传,添加子账号时必传)", required = false, example = "")
    private Integer poFatherId;

    /**
     * 手机唯一识别码
     */
    @ApiModelProperty(value = "手机唯一识别码(必传)", required = true, example = "")
    private String poPhoneIm;              //必填


}
