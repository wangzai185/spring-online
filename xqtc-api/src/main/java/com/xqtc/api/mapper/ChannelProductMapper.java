package com.xqtc.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xqtc.api.entity.ChannelProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ChannelProductMapper继承基类
 */
@Repository
public interface ChannelProductMapper extends BaseMapper<ChannelProductEntity> {

   List<String> selectCityByChannelId(Integer channelId);
}