package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * xqtc_airport_coordinate
 * @author 
 */
@Data
@TableName("xqtc_airport_coordinate")
public class XqtcAirportCoordinateEntity implements Serializable {

    @TableId("xac_id")
    private Integer xacId;

    private String xacCityname;

    private String xacAirportname;

    private String xacKey;

    private String xacLon;

    private String xacLat;

    private Integer xacState;

    private Integer xacCityid;

    private static final long serialVersionUID = 1L;
}