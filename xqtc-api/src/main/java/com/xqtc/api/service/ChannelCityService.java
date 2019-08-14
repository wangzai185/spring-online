package com.xqtc.api.service;

import com.xqtc.api.utils.ApiResult;

public interface ChannelCityService {

    public ApiResult airportAndHighSpeedInfo(Integer channelId, String cityName);

    public ApiResult selectParkByType(String site, String channelId,Integer pageNum,Integer pageSize);

}
