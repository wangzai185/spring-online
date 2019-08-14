package com.xqtc.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xqtc.api.entity.BusinessEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangw
 * @since 2019-07-14
 */
public interface BusinessService extends IService<BusinessEntity> {

    public BusinessEntity selectOne(String accessKey);
}
