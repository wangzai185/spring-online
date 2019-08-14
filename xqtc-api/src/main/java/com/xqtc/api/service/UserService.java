package com.xqtc.api.service;

import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.dto.ForgetPasswordDto;
import com.xqtc.api.dto.LoginDto;
import com.xqtc.api.dto.RegisterDto;

public interface UserService {

    /**
     * 新app业主注册
     *
     * @param registerDto
     * @return
     */
    ApiResult newRegister(RegisterDto registerDto);

    ApiResult parkLogin(LoginDto loginDto);

    ApiResult forgetPassword(ForgetPasswordDto forgetPasswordDto);

    ApiResult getCode(String phone);
}
