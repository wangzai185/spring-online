package com.xqtc.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xqtc.api.dto.LoginDto;
import com.xqtc.api.entity.BusinessEntity;
import com.xqtc.api.mapper.BusinessMapper;
import com.xqtc.api.service.UserService;
import com.xqtc.api.utils.ApiResult;
import com.xqtc.common.annotation.Log;
import com.xqtc.common.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TestController.class
 *
 * @author suntf
 * @date 2019/08/01
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试用api")
public class TestController {

    private final static Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/getInfo")
    @ApiOperation("测试获取信息")
    @Log(title = "测试登录" ,businessType = BusinessType.GRANT)
    public ApiResult getInfo(@Valid @RequestBody LoginDto loginDto){
        Map map = new HashMap();
        map.put("business_state",1);
        map.put("is_deleted",0);
        List<String> list = businessMapper.selectByMap(map);
        List<BusinessEntity> businessEntities = businessMapper.selectList(new QueryWrapper<BusinessEntity>().select("business_state").eq("business_state", 1));
        LOG.info(businessEntities.toString());
        return userService.parkLogin(loginDto);
    }

    @PostMapping("/testRedis")
    public ApiResult test(String x,String j){
        ApiResult apiResult = new ApiResult();
        System.err.println(x+j);
        redisTemplate.opsForValue().set(x,j);
        apiResult.setData(redisTemplate.opsForValue().get(x));
        return apiResult;
    }
}
