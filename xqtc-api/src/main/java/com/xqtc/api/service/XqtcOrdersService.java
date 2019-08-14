package com.xqtc.api.service;

import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.entity.XqtcOrdersEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangw
 * @since 2019-07-23
 */
public interface XqtcOrdersService {

    public ApiResult getOrderList(String userId, String channelId, Integer pageSize, Integer pageNum, String orderStatus);

    public ApiResult getOrderDetailed(String orderId);

}
