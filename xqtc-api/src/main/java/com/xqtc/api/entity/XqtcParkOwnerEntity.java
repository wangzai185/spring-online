package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * xqtc_park_owner
 *
 * @author
 */
@Data
@TableName("xqtc_park_owner")
public class XqtcParkOwnerEntity implements Serializable {

    @TableId("xpo_id")
    private Long xpoId;//编号
    private String xpoIcon;//业主头像
    private String xpoAccount;//业主手机号
    private String xpoNickname;//业主昵称
    private Integer xpoSex;//性别 1-男 2-女
    private String xpoBirth;//生日
    private String xpoEmail;//Email
    private Date xpoTime;//生成时间
    private Integer xpoState;//可用状态 1-是 0-否 2-待审核
    private Integer xpoPhonetype;
    private Integer xpoChildaccount;
    private Integer xpoDuty;
    private String xpoCityCode;
    private String xpoPassword;
    private String xpoIdentityurl;
    private Long xpoChannelid;
    private String xpoUserid;
    private Float xpoFreezeBalance;
    private Float xpoBalance;

    /**
     * 20180223 加上
     */
    private String xpoRemark;//备注

    private static final long serialVersionUID = 1L;
}