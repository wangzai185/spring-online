package com.xqtc.web.controller;

import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.utils.ResultCode;
import com.xqtc.api.dto.ForgetPasswordDto;
import com.xqtc.api.dto.LoginDto;
import com.xqtc.api.dto.RegisterDto;
import com.xqtc.api.service.UserService;
import com.xqtc.common.annotation.Log;
import com.xqtc.common.enums.BusinessType;
import com.xqtc.common.utils.SHA256Util;
import com.xqtc.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api(tags = "业主端app登录注册接口文档")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 新app业主注册
     *
     * @return
     */
//    @Log(title = "新app业主注册", businessType = BusinessType.INSERT)
    @PostMapping("/parkOwner/register")
    @ApiOperation(value = "新app业主注册")
    public ApiResult newRegister(@Valid @RequestBody RegisterDto registerDto) {
        ApiResult apiResult = userService.newRegister(registerDto);
        return apiResult;
    }


    /**
     * 新app业主登录
     *
     * @param loginDto
     * @return
     */
    @Log(title = "新app业主登录", businessType = BusinessType.GRANT)
    @PostMapping("/parkOwner/login")
    @ApiOperation(value = "新app业主登录")
    public ApiResult login(@Valid @RequestBody LoginDto loginDto) {
        return userService.parkLogin(loginDto);
    }

    public static void main(String[] args) {
        String x = "123456";
        System.err.println(SHA256Util.getApacheSHA256Str(x));
    }
    /**
     * 修改业主登录密码
     *
     * @param forgetPasswordDto
     * @return
     */
    @Log(title = "修改业主登录密码", businessType = BusinessType.GRANT)
    @PostMapping("/new/forgetPassword")
    @ApiOperation(value = "新app业主修改密码")
    public ApiResult forgetPassword(@Valid @RequestBody ForgetPasswordDto forgetPasswordDto) {
        return userService.forgetPassword(forgetPasswordDto);
    }


    /**
     * 新app获取验证码
     *
     * @param phone
     * @return
     */
    @Log(title = "新app获取验证码", businessType = BusinessType.GRANT)
    @PostMapping("/getCode")
    @ApiOperation(value = "新app获取验证码")
    public ApiResult gainCode(String phone) {
        ApiResult apiResult = new ApiResult();
        if (ObjectUtils.isEmpty(phone)) {
            apiResult.setError(ResultCode.PHONE_CANNOT_EMPTY);
            return apiResult;
        }
        return userService.getCode(phone);
    }


}
