package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangw
 * @since 2019-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JhkjParkOwner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业主id
     */
    @TableId(value = "po_id", type = IdType.AUTO)
    private Long poId;

    /**
     * 业主头像
     */
    private String poIcon;

    /**
     * 业主手机号
     */
    private String poAccount;

    /**
     * 业主昵称
     */
    private String poNickName;

    /**
     * 性别 1-男 2-女
     */
    private Integer poSex;

    /**
     * 生日
     */
    private String poBirth;

    /**
     * 密码
     */
    private String poPassword;

    /**
     * 身份证号
     */
    private String poIdNumber;

    /**
     * 渠道id 1：安卓2：ios 3:  网站4：微信
     */
    private Integer poChannelId;

    /**
     * 冻结余额
     */
    private BigDecimal poFreezeBalance;

    /**
     * 余额
     */
    private BigDecimal poBalance;

    /**
     * 备注
     */
    private String poRemark;

    /**
     * 是否为子账号:0:子账号 1:主账号
     */
    private Integer poIsChild;

    /**
     * 子账号的权限设置
     */
    private String childOauthId;

    /**
     * 是否当值:0:当值 1:不当值
     */
    private Integer poIsDuty;

    /**
     * 父账号id
     */
    private Integer poFatherId;

    /**
     * 手机类型 1：安卓 ,2：ios , 3:  网站 ,4：微信
     */
    private Integer poPhoneType;

    /**
     * 可用状态 0-不可用 1-可用  2-待审核
     */
    private Integer poState;

    /**
     * 是否删除 0正常 1删除
     */
    private Integer isDeleted;

    /**
     * 极光推送
     */
    private String imPushId;

    /**
     * 极光
     */
    private String imId;

    /**
     * 最后一次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 手机唯一识别码
     */
    private String poPhoneIm;

}
