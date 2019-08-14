package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangw
 * @since 2019-07-23
 */
@Data
@TableName("xqtc_orders")
public class XqtcOrdersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "xo_id", type = IdType.AUTO)
    private Long xoId;

    private Long xcoId;

    private Long xpId;

    private String xoNumber;

    private String xoCarOwnernick;

    private String xoPlatenumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xoTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xoStarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xoEndtime;

    private Integer xoType;

    private Integer xoPaystate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xoRealstarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date xoRealendtime;

    private Float xoRealpayable;

    private Float xoRealpay;

    private Integer xoState;

    private Float xoPayable;

    private Float xoPay;

    private Float xoPrepay;

    private String xoQrcode;

    private String xoParkname;

    private String xoParkaddress;

    private Integer xoParktype;

    private String xoCharge;

    private Integer xoParkday;

    private String xoPreferential;

    private Float xoDiscountamount;

    private String xoStartflightnumber;

    private String xoReturnflightnumber;

    private Integer xoNumberofpeers;

    private Float xoAmountofmoney;

    private Integer xoMindays;

    private Float xoPayed;

    private Long xoEnterXpid;

    private Long xoEndXpid;

    private String updater;

    @TableField("updateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @Version
    private Long version;

    @TableField("orderCategory")
    private Integer orderCategory;

    @TableField("finalCostInfo")
    private String finalCostInfo;

    private String xpDiscount;

    @TableField("xo_bookTime")
    private String xoBooktime;

    @TableField("xo_bookType")
    private Integer xoBooktype;

    /**
     * 来源
     */
    private String xoSource;

    private String remark;

    @TableField("xo_valetFee")
    private Float xoValetfee;

    private Integer carcount;

    private String xoOvertimefee;

    private String xpeId;

    private String xoAdditionalinfo;

    private Integer xoIsdrop;

    private Integer xoIspending;

    private String carOwnerRemark;

    private Integer isAppraisedflag;

    /**
     * 1 正常价  0.88 会员折扣价
     */
    private Float xoDiscount;

    private String xoCancelreason;

    private String xoChannelPrice;

    private String xoParkPrice;

    private Long xoVipCouponId;

    private Long xoBookCouponId;

    private Float xoBookCouponMoney;

    private Long xoFinalCouponId;

    private Float xoFinalCouponMoney;

    private Integer xoPushState;

    private Float xoPremoney;

    private Float xoPrerealmoney;

    private Integer xoPremindays;

    private Integer xoParkcategory;

    private Float xoPartnerscale;

    private Float xoBookXqmoney;

    /**
     * 预付实际付的，支付宝或者微信
     */
    private Float xoBookPaymoney;

    private Float xoFinalXqmoney;

    private Float xoFinalPaymoney;

    /**
     * 线下付款
     */
    private Float xoOfflinepay;

    private Float xoMoneyfromchannel;

    private Float xoMoneytopark;

    private Float xoProfit;

    private Float xoAdjust;

    private Integer xoSettlestatus;

    private String xoBookPricelist;

    private String xoFinalPricelist;

    private Integer xoBookDays;

    private Integer xoFinalDays;

    private String xoExceedPrice;

    private Integer xoFreeminutes;

    private Integer xoPaiddays;

    private Float xoPaidmoney;

    @TableField("outFlightNo")
    private String outFlightNo;

    @TableField("xo_book_listAddOnSale")
    private String xoBookListaddonsale;

    @TableField("xo_final_listAddOnSale")
    private String xoFinalListaddonsale;

    @TableField("isPartnerOrder")
    private Integer isPartnerOrder;

    /**
     * 1是普通订单2是代泊订单
     */
    private Integer insteadParkType;

    /**
     * 延迟取车时间
     */
    @TableField("delayTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date delayTime;

    /**
     * 付款模式 1预付 2全额
     */
    @TableField("payType")
    private Integer payType;

    /**
     * 医院价格配置对象
     */
    @TableField("hospitalChargeInfo")
    private String hospitalChargeInfo;

    /**
     * 是否是第三方订单 1是
     */
    private Integer isotth;


}
