package com.xqtc.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xqtc.api.entity.ChannelConfEntity;
import com.xqtc.api.entity.ChannelUserEntity;
import com.xqtc.api.entity.XqtcParkEntity;
import com.xqtc.api.mapper.ChannelConfMapper;
import com.xqtc.api.mapper.ChannelUserMapper;
import com.xqtc.api.mapper.XqtcParkMapper;
import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.entity.XqtcOrdersEntity;
import com.xqtc.api.mapper.XqtcOrdersMapper;
import com.xqtc.api.service.XqtcOrdersService;
import com.xqtc.api.utils.ResultCode;
import com.xqtc.api.vo.CommonH5Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhangw
 * @since 2019-07-23
 */
@Service
public class XqtcOrdersServiceImpl implements XqtcOrdersService {

    @Autowired
    private XqtcOrdersMapper xqtcOrdersMapper;
    @Autowired
    private XqtcParkMapper xqtcParkMapper;
    @Autowired
    private ChannelConfMapper channelConfMapper;
    @Autowired
    private ChannelUserMapper channelUserMapper;


    @Override
    public ApiResult getOrderList(String userId, String channelId, Integer pageSize, Integer pageNum, String orderStatus) {
        ApiResult apiResult = new ApiResult();
        ChannelUserEntity channelUserEntity = channelUserMapper.selectOne(new QueryWrapper<ChannelUserEntity>().eq("open_id",userId));
        ChannelConfEntity channelConfEntity = channelConfMapper.selectById(channelId);
        if (channelConfEntity == null) {
            apiResult.setError(ResultCode.CHECK_USER_FAIL,"没有这个渠道！");
            return apiResult;
        }
        QueryWrapper<XqtcOrdersEntity> queryWrapper = new QueryWrapper<>();
        if (orderStatus.equals("done")) {
            queryWrapper.select("xo_id", "xco_id", "xo_number", "xo_time", "xo_state", "xp_id").eq("xco_id", channelUserEntity.getXcoId()).eq("xo_source", channelConfEntity.getChannelName()).in("xo_state", "4", "5"); //eq("xo_state", "5").or().eq("xo_state", "4");
        } else if (orderStatus.equals("underway")) {
            queryWrapper.select("xo_id", "xco_id", "xo_number", "xo_time", "xo_state", "xp_id").eq("xco_id", channelUserEntity.getXcoId()).eq("xo_source", channelConfEntity.getChannelName()).in("xo_state", "1", "2"); //eq("xo_state", "1").or().eq("xo_state", "2");
        } else if (orderStatus.equals("all")) {
            queryWrapper.select("xo_id", "xco_id", "xo_number", "xo_time", "xo_state", "xp_id").eq("xco_id", channelUserEntity.getXcoId()).eq("xo_source", channelConfEntity.getChannelName());
        } else if (orderStatus.equals("unpaid")) {
            queryWrapper.select("xo_id", "xco_id", "xo_number", "xo_time", "xo_state", "xp_id").eq("xco_id", channelUserEntity.getXcoId()).eq("xo_source", channelConfEntity.getChannelName()).eq("xo_state", "11");
        }else {
            apiResult.setError(ResultCode.CHECK_USER_FAIL,"订单类别不存在！");
            return apiResult;
        }
        Page<XqtcOrdersEntity> pageInfo = new Page<>(pageNum, pageSize);
        IPage<XqtcOrdersEntity> iPage = xqtcOrdersMapper.selectPage(pageInfo, queryWrapper);

        List<CommonH5Vo> list = new ArrayList<>();
        for (XqtcOrdersEntity xqtcOrdersEntity : iPage.getRecords()) {
            CommonH5Vo commonH5Vo = new CommonH5Vo();
            XqtcParkEntity xqtcParkEntity = xqtcParkMapper.selectOne(new QueryWrapper<XqtcParkEntity>().eq("xp_id", xqtcOrdersEntity.getXpId()));
            commonH5Vo.setParkCoordinate(xqtcParkEntity.getXpLongitudelatitude());  //停车场坐标
            commonH5Vo.setXqtcParkName(xqtcParkEntity.getXpName());
            commonH5Vo.setXqtcParkTime(xqtcOrdersEntity.getXoTime());
            commonH5Vo.setOrderId(xqtcOrdersEntity.getXoId().toString());
            commonH5Vo.setOrderNumber(xqtcOrdersEntity.getXoNumber());
            commonH5Vo.setXqtcParkStatus(xqtcOrdersEntity.getXoState().toString());
            commonH5Vo.setXqtcParkPhone(xqtcParkEntity.getXpDutyphone());
            commonH5Vo.setSparePhone(xqtcParkEntity.getReserved6());
            list.add(commonH5Vo);
        }
        apiResult.setData(list);
        return apiResult;
    }

    @Override
    public ApiResult getOrderDetailed(String orderId) {
        ApiResult apiResult = new ApiResult();
        XqtcOrdersEntity xqtcOrdersEntity = xqtcOrdersMapper.selectById(orderId);
        apiResult.setData(xqtcOrdersEntity);
        return apiResult;
    }
}
