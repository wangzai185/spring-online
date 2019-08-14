package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangw
 * @since 2019-07-24
 */
@Data
@TableName("xqtc_park")
public class XqtcParkEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long xphId;

    @TableId(value = "xp_id", type = IdType.AUTO)
    private Long xpId;

    private String xpName;

    private String xpAddress;

    private String xpProvince;

    private String xpCity;

    private Integer xpProvinceid;

    private Integer xpCityid;

    private String xpLongitudelatitude;

    @TableField("xp_airportCoordinate")
    private String xpAirportcoordinate;

    @TableField("xp_railwayStationCoordinate")
    private String xpRailwaystationcoordinate;

    private Integer xpType;

    private LocalDateTime xpTime;

    private Integer xpState;

    private Integer xpIncount;

    private Integer xpInempty;

    private Integer xpOutcount;

    private Integer xpOutempty;

    private Float xpStarlevel;

    private String xpRemark;

    private String xpDutyphone;

    private String xpIntroduce;

    private String xpXppfids;

    private Integer xpChargtype;

    private Float xpPrepay;

    private Integer xpIdcertified;

    private Integer xpLicencedcertified;

    private Integer xpArtificialcertified;

    private Integer xpTotalorder;

    private Integer xpDistance;

    private Integer category;

    @TableField("openingBegin")
    private String openingBegin;

    @TableField("openingEnd")
    private String openingEnd;

    @TableField("serviceItem")
    private String serviceItem;

    @TableField("serviceInfo")
    private String serviceInfo;

    @TableField("freeTimeBegin")
    private String freeTimeBegin;

    private String creator;

    private String updater;

    @TableField("createDate")
    private LocalDateTime createDate;

    @TableField("updateDate")
    private LocalDateTime updateDate;

    @Version
    private Long version;

    @TableField("freeTimeEnd")
    private String freeTimeEnd;

    private String prebook;

    @TableField("freeTimeBegin2")
    private String freeTimeBegin2;

    @TableField("freeTimeEnd2")
    private String freeTimeEnd2;

    private String reserved1;

    private String reserved2;

    private String reserved3;

    private String reserved4;

    /**
     * 携程机票用到对应
     */
    private String reserved5;

    private String reserved6;

    private String reserved7;

    private String bizname;

    private Integer online;

    private String area;

    /**
     * 作为综合排名使用
     */
    private Integer xpRanking;

    private Integer oCountBuff;

    private Integer iCount;

    private Integer iCountBuff;

    private String xpOvertimefee;

    @TableField("xp_specialPrice")
    private Integer xpSpecialprice;

    /**
     * 会员停车场 1是 0否
     */
    private Integer xpVip;

    /**
     * 百度地图短链接
     */
    private String xpBaidumapurl;

    /**
     * 高德地图短链接
     */
    private String xpGaodemapurl;

    /**
     * 腾讯地图短链接
     */
    private String xpQqmapurl;

    /**
     * 是否合伙人停车场
     */
    private Integer xpPartner;

    /**
     * 保证金金额,交了多少金额就是多少
     */
    private Float xpDeposit;

    private String xpEmergencyContact;

    private String xpKeyword;

    /**
     * 月销量调整值
     */
    private Integer xpMonthlySalesAdjustValue;

    private String xpCarSeating;

    private Integer xpToAirportMinutes;

    private Integer xpCarCover;

    private Integer xpCarWash;

    private String xpActivity;

    private Integer xpOnThePin;

    /**
     * 1:自泊2:代泊3:自泊+代泊
     */
    private Integer xpInsteadParkType;

    private Float xpInsteadParkAmount;

    /**
     * 代泊库存
     */
    private Integer xpInsteadParkInventory;

    /**
     * 代泊审核状态0未申请1待审核2已审核
     */
    private Integer xpInsteadState;

    @TableField("xp_vipPrice")
    private Integer xpVipprice;

    /**
     * 营业时间 “08:30;20:30”  全天   空字符串
     */
    private String xpBusinessTimeStr;

    private String contactsPhone;

    private String urgentName;


}
