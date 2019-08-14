package com.xqtc.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.utils.RedisUtils;
import com.xqtc.api.utils.ResultCode;
import com.xqtc.api.dto.AddInformationDto;
import com.xqtc.api.dto.UpdateInformationDto;
import com.xqtc.api.entity.JhkjInformation;
import com.xqtc.api.mapper.JhkjInformationMapper;
import com.xqtc.api.service.JhkjInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhangw
 * @since 2019-07-23
 */
@Service
@Transactional
public class JhkjInformationServiceImpl implements JhkjInformationService {

    @Autowired
    JhkjInformationMapper jhkjInformationMapper;
    @Autowired
    private RedisUtils redisUtils;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public ApiResult addInformation(AddInformationDto addInformationDto) {
        ApiResult apiResult = new ApiResult();
        JhkjInformation jhkjInformation = new JhkjInformation();
        jhkjInformation.setAuthor(addInformationDto.getAuthor());
        jhkjInformation.setInformationDesc(addInformationDto.getInformationDesc());
        jhkjInformation.setInformationType(addInformationDto.getInformationType());
        jhkjInformation.setTitle(addInformationDto.getTitle());
        jhkjInformation.setContent(addInformationDto.getContent());
        jhkjInformation.setPictureUrl(addInformationDto.getPictureUrl());


        jhkjInformation.setInformationState(0);//`information_state` int(10) DEFAULT NULL COMMENT '资讯状态(0:未发布 1:已发布 )',
        jhkjInformation.setIsDeleted(1);
        jhkjInformation.setPublishTime(new Date());
        jhkjInformation.setCreateTime(new Date());
        jhkjInformation.setUpdateTime(new Date());
        int count = jhkjInformationMapper.insert(jhkjInformation);
        if (count == 0) {
            //入库失败
            apiResult.setError(ResultCode.INSERT_ERR);
            return apiResult;
        }
        return apiResult;
    }

    @Override
    public ApiResult updateInformation(UpdateInformationDto updateInformationDto) {
        ApiResult apiResult = new ApiResult();
        JhkjInformation jhkjInformation = jhkjInformationMapper.selectById(updateInformationDto.getInformationId());
        if (jhkjInformation == null) {
            apiResult.setError(ResultCode.INFORMATION_NON_EXISTENT);
            return apiResult;
        }
        if (!ObjectUtils.isEmpty(updateInformationDto.getAuthor())) {
            jhkjInformation.setAuthor(updateInformationDto.getAuthor());
        }
        if (!ObjectUtils.isEmpty(updateInformationDto.getInformationDesc())) {
            jhkjInformation.setInformationDesc(updateInformationDto.getInformationDesc());
        }
        if (updateInformationDto.getInformationType() != null) {
            jhkjInformation.setInformationType(updateInformationDto.getInformationType());
        }

        if (!ObjectUtils.isEmpty(updateInformationDto.getTitle())) {
            jhkjInformation.setTitle(updateInformationDto.getTitle());
        }
        if (!ObjectUtils.isEmpty(updateInformationDto.getContent())) {
            jhkjInformation.setContent(updateInformationDto.getContent());
        }
        if (!ObjectUtils.isEmpty(updateInformationDto.getPictureUrl())) {
            jhkjInformation.setPictureUrl(updateInformationDto.getPictureUrl());
        }
        if (updateInformationDto.getIsDeleted() != null) {
            jhkjInformation.setIsDeleted(updateInformationDto.getIsDeleted());
        }
        if (updateInformationDto.getInformationState() != null) {
            jhkjInformation.setInformationState(updateInformationDto.getInformationState());
            if (updateInformationDto.getInformationState() == 1) {
                jhkjInformation.setPublishTime(new Date());
            }
        }
        jhkjInformation.setUpdateTime(new Date());
        int count = jhkjInformationMapper.updateById(jhkjInformation);
        if (count == 0) {
            //入库失败
            apiResult.setError(ResultCode.UPDATE_ERR);
            return apiResult;
        }
        return apiResult;
    }

    @Override
    public ApiResult selectInformationPageList(Integer page, Integer limit, Integer informationState, Integer type, Integer orderType) {
        ApiResult apiResult = new ApiResult();
        QueryWrapper<JhkjInformation> queryWrapper = new QueryWrapper<>();
        if (type == 2) {
            queryWrapper.select("information_id", "information_type", "information_state", "title", "picture_url","publish_time").eq("information_state", informationState).eq("is_deleted", "1");
        } else {
            queryWrapper.select("information_id", "information_type", "title","picture_url","publish_time").eq("information_state", informationState).eq("is_deleted", "1").eq("information_type", type);
        }
        if (orderType == 0)
            queryWrapper.orderByDesc("publish_time");
        if (orderType == 1)
            queryWrapper.orderByDesc("create_time");

        Page<JhkjInformation> page1 = new Page<JhkjInformation>(page, limit);
        IPage<JhkjInformation> iPage = jhkjInformationMapper.selectPage(page1, queryWrapper);
        apiResult.setData(iPage);
        return apiResult;
    }

    @Override
    public ApiResult jhkjInformationService(String id) {
        ApiResult apiResult = new ApiResult();
        Map<Object, Object> mapResult = redisUtils.hGetAll(id);
        if (!mapResult.isEmpty()) {
            apiResult.setData(mapResult);
        } else {
            JhkjInformation jhkjInformation = jhkjInformationMapper.selectById(Integer.valueOf(id));
            Map<Object, Object> map = new HashMap<>();
            if( jhkjInformation!= null ) {
                map.put("title", jhkjInformation.getTitle());
                map.put("content", jhkjInformation.getContent());
                map.put("pictureUrl", jhkjInformation.getPictureUrl());
                map.put("publishTime", sdf.format(jhkjInformation.getPublishTime()));
                redisUtils.hPutAll(jhkjInformation.getInformationId() + "", map);
                mapResult = redisUtils.hGetAll(id);
            }
            apiResult.setData(mapResult);
        }
        return apiResult;
    }

    @Override
    public ApiResult deletInformationById(Integer id) {
        ApiResult apiResult = new ApiResult();
        int count = jhkjInformationMapper.deleteById(id);
        if (count == 0) {
            //入库失败
            apiResult.setError(ResultCode.DELET_ERR);
            return apiResult;
        }
        return apiResult;

    }
}
