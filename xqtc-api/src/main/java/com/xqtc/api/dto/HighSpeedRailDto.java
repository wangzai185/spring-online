package com.xqtc.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HighSpeedRailDto implements Serializable {

    private String xhsrCityName;
     /**
     * 状态
     */
    private Byte xhsrState;
}
