package com.xqtc.api.service;

import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.dto.AddInformationDto;
import com.xqtc.api.dto.UpdateInformationDto;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangw
 * @since 2019-07-23
 */

public interface JhkjInformationService {

    ApiResult addInformation(AddInformationDto addInformationDto);

    ApiResult updateInformation(UpdateInformationDto updateInformationDto);

    ApiResult selectInformationPageList(Integer page, Integer limit, Integer informationState,Integer type, Integer orderType);

    ApiResult jhkjInformationService(String id);

    ApiResult deletInformationById(Integer id);
}
