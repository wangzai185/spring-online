package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * channel_city
 * @author 
 */
@Data
@TableName("channel_city")
public class ChannelCityEntity implements Serializable {

    @TableId("city_id")
    private Long cityId;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 省份code
     */
    private String provinceCode;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 停车场类型 1 高铁 2 机场 3 港口 
     */
    private Integer parkType;

    /**
     * 城市名称
     */
    private String cityName;

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
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}