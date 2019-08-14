package com.xqtc.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommonH5Vo {

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id", required = false)
    private String orderId;
    /**
     * 停车场名称
     */
    @ApiModelProperty(value = "停车场名称", required = false)
    private String  xqtcParkName;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间", required = false)
    private Date xqtcParkTime;

    /**
     * 状态信息
     */
    @ApiModelProperty(value = "状态信息:0 取消 1 未进场 2 已进场 3已离场 4 已完成 5 自动结单 6 订单未生成 11 待支付", required = true)
    private String  xqtcParkStatus;

    /**
     * 坐标信息
     */
    @ApiModelProperty(value = "坐标", required = false)
    private String  parkCoordinate;

    /**
     * 值班电话
     */
    @ApiModelProperty(value = "值班电话", required = false)
    private String  xqtcParkPhone;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号", required = false)
    private String  orderNumber;

    /**
     * 备用电话
     */
    @ApiModelProperty(value = "备用电话", required = false)
    private String  sparePhone;

    /**
     * 备用电话
     */
    @ApiModelProperty(value = "月销量", required = false)
    private String  monthlySales;

}
