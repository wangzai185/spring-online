package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * xqtc_car_owner
 *
 * @author
 */
@Data
@TableName("xqtc_car_owner")
public class XqtcCarOwnerEntity implements Serializable {

    @TableId("xco_id")
    private Long xcoId;//车主表流水id
    private String xcoIcon;//头像路径
    private String xcoAccount;//账号(手机号码)
    private String xcoNickname;//昵称(如果未填则显示账号)
    private Integer xcoSex;//性别1：男0：女
    private String xcoBirth;//出生年月
    private String xcoEmail;//电子邮箱
    private Date xcoTime;//注册时间
    private Integer xcoState;//状态1：正常0：注销2:未审核
    private Float xcoBalance;//账号余额
    private Integer xcoParkdistance;//停车距离
    private String xcoIdentityurl;//车主身份证照片路径
    private Integer xcoPhonetype;//手机类型1：安卓2：ios 3:  网站4：微信
    private String xcoPlatenumber;//车牌号
    private String xcoDrivinglicenseurl;//车辆行驶证url
    private String xcoCityCode;//所在(注册时候)城市的城市代码
    private String xcoPassword;//密码
    private Long xcoChannelid;//百度推送中的channelid
    private String xcoUserid;//百度推送中的userId
    private Float xcoFreezeBalance;//被冻结余额
    private String xcoToken;//手机唯一识别码
    private String xcoAccesstoken;//微信第三方登录返回的token  APPID
    private Integer xcoSource;//用户来源1：安卓2：ios3：微信4：网站5: 携程对接 6: 分享
    private String xcoSpcode;//渠道编码
    private String xcoCode;//分享码
    private String xcoChannel;//渠道
    private String xcoUpdater;//更新人
    private Date xcoUpdatedate;//更新时间
    private String remark;//备注
    private Integer xcoViptype;//会员类型:0 普通会员 1金卡2黑卡（默认为0）
    private String tempPassword;//用来放修改前的密码，用来临时登录看一下这个号的状态
    /**
     * 1用户 2 机器人
     */
    private Integer xcoUserType;

    private static final long serialVersionUID = 1L;

}