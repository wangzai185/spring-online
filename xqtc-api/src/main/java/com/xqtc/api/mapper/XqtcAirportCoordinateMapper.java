package com.xqtc.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xqtc.api.entity.XqtcAirportCoordinateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * XqtcAirportCoordinateMapper继承基类
 */
@Repository
public interface XqtcAirportCoordinateMapper extends BaseMapper<XqtcAirportCoordinateEntity> {

    List<String> selectAirportByCityName(String cityName);

}