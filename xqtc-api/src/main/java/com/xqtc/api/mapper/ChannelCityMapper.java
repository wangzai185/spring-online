package com.xqtc.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xqtc.api.entity.ChannelCityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ChannelCityMapper继承基类
 */
@Repository
public interface ChannelCityMapper extends BaseMapper<ChannelCityEntity> {

    List<String> selectByParkType(String ciryName);
}