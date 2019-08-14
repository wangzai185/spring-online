package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * xqtc_high_speed_rail
 * @author 
 */
@Data
@TableName("xqtc_high_speed_rail")
public class XqtcHighSpeedRailEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId("xhsr_id")
    private Integer xhsrId;

    /**
     * 城市名称
     */
    private String xhsrCityName;

    /**
     * 高铁站名称
     */
    private String xhsrHighSpeedName;

    private String xhsrKey;

    /**
     * 状态
     */
    private Byte xhsrState;

    /**
     * 城市id
     */
    private Integer xhsrCityid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Byte isDeleted;

    private static final long serialVersionUID = 1L;
}