package com.xqtc.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqtc.api.entity.BusinessEntity;
import com.xqtc.api.mapper.BusinessMapper;
import com.xqtc.api.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangw
 * @since 2019-07-14
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, BusinessEntity> implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public BusinessEntity selectOne(String accessKey) {
        BusinessEntity business = businessMapper.selectOne(new QueryWrapper<BusinessEntity>().eq("access_key",accessKey));
        return business;
    }
}
