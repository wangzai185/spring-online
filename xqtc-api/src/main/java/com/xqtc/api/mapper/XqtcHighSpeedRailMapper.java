package com.xqtc.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xqtc.api.entity.XqtcHighSpeedRailEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * XqtcHighSpeedRailMapper继承基类
 */
@Repository
public interface XqtcHighSpeedRailMapper extends BaseMapper<XqtcHighSpeedRailEntity> {

    List<String> selectHighSpeedByCityName(String xhsrCityName,Byte xhsrState);
}