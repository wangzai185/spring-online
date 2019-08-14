package com.xqtc.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xqtc.api.entity.ChannelProductEntity;
import com.xqtc.api.entity.XqtcHighSpeedRailEntity;
import com.xqtc.api.mapper.ChannelCityMapper;
import com.xqtc.api.mapper.ChannelProductMapper;
import com.xqtc.api.mapper.XqtcHighSpeedRailMapper;
import com.xqtc.api.service.ChannelCityService;
import com.xqtc.api.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChannelCityServiceImpl implements ChannelCityService {

    @Autowired
    private ChannelCityMapper channelCityMapper;
    @Autowired
    private ChannelProductMapper channelProductMapper;
    @Autowired
    private XqtcHighSpeedRailMapper xqtcHighSpeedRailMapper;

    public ApiResult airportAndHighSpeedInfo(Integer channelId, String cityName) {
        ApiResult apiResult = new ApiResult();
        List<String> parkType = channelCityMapper.selectByParkType(cityName);    //城市停车类型 1 高铁站停车 2 机场停车 3港口 4迪士尼
        List highSpeed = xqtcHighSpeedRailMapper.selectHighSpeedByCityName(cityName, (byte) 1);//高铁
        List airport = xqtcHighSpeedRailMapper.selectHighSpeedByCityName(cityName, (byte) 2);        //机场
        List port = xqtcHighSpeedRailMapper.selectHighSpeedByCityName(cityName, (byte) 3);        //口岸
        List disney = xqtcHighSpeedRailMapper.selectHighSpeedByCityName(cityName, (byte) 4);    //迪士尼
        List hospital = xqtcHighSpeedRailMapper.selectHighSpeedByCityName(cityName, (byte) 5);      //医院
        Map map = new HashMap();
        map.put("parkType",parkType);
        map.put("airport", airport);
        map.put("highSpeed", highSpeed);
        map.put("xqPort", port);
        map.put("disney", disney);
        map.put("hospital", hospital);
        apiResult.setData(map);
        return apiResult;
    }

    @Override
    public ApiResult selectParkByType(String site, String channelId, Integer pageNum, Integer pageSize) {
        ApiResult apiResult = new ApiResult();
        QueryWrapper<ChannelProductEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("site", site).eq("cc_id", channelId);
        Page<ChannelProductEntity> pageInfo = new Page<>(pageNum, pageSize);
        IPage<ChannelProductEntity> iPage = channelProductMapper.selectPage(pageInfo, queryWrapper);
        apiResult.setData(iPage.getRecords());
        return apiResult;
    }

}
