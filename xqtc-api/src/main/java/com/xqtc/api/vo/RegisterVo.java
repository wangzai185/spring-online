package com.xqtc.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RegisterVo {
    @ApiModelProperty(value = "手机验证码  (true)", required = true, example = "123456")
    private String phoneCode;
    @ApiModelProperty(value = "用户类型 0车主 1业主 (true)", required = true, example = "0")
    private Integer userType;
    @ApiModelProperty(value = "手机号码 (true)", required = true, example = "18552456191")
    private String phone;
    @ApiModelProperty(value = "密码 (true)", required = true, example = "e10adc3949ba59abbe56e057f20f883e")
    private String password;
    @ApiModelProperty(value = "手机类型1：安卓2：ios 3:  网站4：微信 (true)", required = true ,example ="1" )
    private Integer phoneType;
    @ApiModelProperty(value = "会员类型:0 普通会员 1金卡2黑卡(false)（默认为0)", required = false)
    private Integer viptype;
    @ApiModelProperty(value = " 1用户 2 机器人(false)（默认为0）", required = false)
    private Integer isRobot;
    @ApiModelProperty(value = "手机唯一识别码 (false)", required = false)
    private String token;
    @ApiModelProperty(value = "微信第三方登录返回的token  APPID (false)", required = false)
    private String accesstoken;
    @ApiModelProperty(value = "用户来源1：安卓2：ios3：微信4：网站5: 携程对接 6: 分享 (true)", required = true ,example = "1")
    private Integer source;
    @ApiModelProperty(value = "渠道编码 (false)", required = false)
    private String spcode;

}