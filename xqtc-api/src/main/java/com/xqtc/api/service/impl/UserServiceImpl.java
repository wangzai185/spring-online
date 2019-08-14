package com.xqtc.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xqtc.api.utils.ApiResult;
import com.xqtc.api.utils.HttpClientUtils;
import com.xqtc.api.utils.ResultCode;
import com.xqtc.api.config.AppConfig;
import com.xqtc.api.dto.ForgetPasswordDto;
import com.xqtc.api.dto.LoginDto;
import com.xqtc.api.dto.RegisterDto;
import com.xqtc.api.entity.JhkjParkOwner;
import com.xqtc.api.enums.IsDeletedEnum;
import com.xqtc.api.enums.PoIsDutyEnum;
import com.xqtc.api.enums.PoStateEnum;
import com.xqtc.api.mapper.JhkjParkOwnerMapper;
import com.xqtc.api.mapper.XqtcCarOwnerMapper;
import com.xqtc.api.mapper.XqtcParkOwnerMapper;
import com.xqtc.api.service.UserService;
import com.xqtc.common.utils.Md5Utils;
import com.xqtc.common.utils.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private XqtcCarOwnerMapper xqtcCarOwnerMapper;
    @Autowired
    private XqtcParkOwnerMapper xqtcParkOwnerMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private JhkjParkOwnerMapper jhkjParkOwnerMapper;

    @Autowired
    private AppConfig appConfig;

    /**
     * 新app业主注册
     *
     * @param registerDto
     * @return
     */
    @Override
    @Transactional
    public ApiResult newRegister(RegisterDto registerDto) {
        ApiResult apiResult = new ApiResult();
        // 验证码校验
        if (!checkVerificationCode(registerDto.getPoAccount(), registerDto.getMsgCode())) {
            apiResult.setError(ResultCode.VALIDATION_CODE_INVALID);
            // 验证码不正确返回
            apiResult.setError(ResultCode.VALIDATION_CODE_INVALID);
            return apiResult;
        }

        // 校验手机号是否已被注册
        Integer countPoPhone = jhkjParkOwnerMapper.selectCount(new QueryWrapper<JhkjParkOwner>().eq("po_account", registerDto.getPoAccount()).eq("is_deleted", 0));
        if (countPoPhone != null && countPoPhone > 0) {
            apiResult.setError(ResultCode.USER_EXIST, "用户已经存在！不允许重复注册！");
            return apiResult;
        }
        // 手机号没有被注册
        JhkjParkOwner jhkjParkOwner = new JhkjParkOwner();
        jhkjParkOwner.setPoAccount(registerDto.getPoAccount());
        jhkjParkOwner.setPoNickName(registerDto.getPoAccount().substring(0, 3) + "****" + registerDto.getPoAccount().substring(7));
        jhkjParkOwner.setPoPassword(SHA256Util.getSHA256String(registerDto.getPoPassword()));
        jhkjParkOwner.setPoChannelId(registerDto.getPoChannelId()); //渠道id
        jhkjParkOwner.setPoFreezeBalance(new BigDecimal(0));
        jhkjParkOwner.setPoBalance(new BigDecimal(0));

        jhkjParkOwner.setPoPhoneType(registerDto.getPoPhoneType());
        jhkjParkOwner.setPoState(PoStateEnum.AUTHSTR.getCode());//默认待审核
        jhkjParkOwner.setIsDeleted(IsDeletedEnum.NORMAL.getCode());
        jhkjParkOwner.setLastLoginTime(LocalDateTime.now());
        jhkjParkOwner.setPoPhoneIm(registerDto.getPoPhoneIm());//手机唯一识别码

        jhkjParkOwner.setCreateTime(LocalDateTime.now());
        jhkjParkOwner.setModifyTime(LocalDateTime.now());
        jhkjParkOwner.setPoIsDuty(PoIsDutyEnum.NOT_DUTY.getCode());//默认不当值
        jhkjParkOwner.setPoIsChild(registerDto.getPoIsChild());//是否为子账号:0:子账号 1:主账号
        if (registerDto.getPoIsChild() == 0) {
            //子账号注册
            jhkjParkOwner.setChildOauthId(registerDto.getChildOauthId());//子账号的权限设置
            jhkjParkOwner.setPoFatherId(registerDto.getPoFatherId());    //poFatherId 父账号id
        }
        jhkjParkOwnerMapper.insert(jhkjParkOwner);
        //注册完成 自动登录
        LoginDto loginDto = new LoginDto();
        loginDto.setPoPhone(registerDto.getPoAccount());
        loginDto.setPoPassword(registerDto.getPoPassword());
        loginDto.setPoPhoneType(registerDto.getPoPhoneType());
        //注册成功后自动登录
        loginDto.setPoPassword(loginDto.getPoPassword());
        apiResult = parkLogin(loginDto);
        return apiResult;
    }

    /**
     * 新app业主登录
     *
     * @param loginDto
     * @return
     */
    @Override
    public ApiResult parkLogin(LoginDto loginDto) {
        ApiResult apiResult = new ApiResult();
        //业主
        JhkjParkOwner parkOwner = jhkjParkOwnerMapper.selectOne(new QueryWrapper<JhkjParkOwner>().eq("po_account", loginDto.getPoPhone()).eq("is_deleted", 0).ne("po_state", 0));
        if (ObjectUtils.isEmpty(parkOwner)) {
            apiResult.setError(ResultCode.USER_IS_NOT_EXIST);
            return apiResult;
        }
        if (!SHA256Util.getSHA256String(loginDto.getPoPassword()).equals(parkOwner.getPoPassword())) {
            //密码不正确
            apiResult.setError(ResultCode.USER_NAME_PASSWORD_ERROR, "密码不存在或密码错误！");
            return apiResult;
        }

        //校验通过用户运行登陆
        //校验通过用户运行登陆 template
        String token = Md5Utils.MD5(parkOwner.getPoPassword());
        template.opsForValue().set(loginDto.getPoPhone() + "parkLogin", token, 100, TimeUnit.DAYS);
//        template.opsForValue().set(token, loginDto.getPoPhone() + "," + UserTypeEnum.PROPRIETOR.getCode());
//        template.expire(token, 100000, TimeUnit.SECONDS); //设置超时时间10秒 第三个参数控制时间单位，详情查看TimeUnit
        apiResult.setData(token);
        return apiResult;
    }

    @Override
    public ApiResult forgetPassword(ForgetPasswordDto forgetPasswordDto) {
        ApiResult apiResult = new ApiResult();
        //查看用户是否存在
        JhkjParkOwner parkOwner = jhkjParkOwnerMapper.selectOne(new QueryWrapper<JhkjParkOwner>().eq("po_account", forgetPasswordDto.getPoPhone()).eq("is_deleted", 0).ne("po_state", 0));
        if (ObjectUtils.isEmpty(parkOwner)) {
            apiResult.setError(ResultCode.USER_IS_NOT_EXIST);
            return apiResult;
        }
        //校验验证码
        //验证码方式
        if (!checkVerificationCode(forgetPasswordDto.getPoPhone(), forgetPasswordDto.getCode())) {
            apiResult.setError(ResultCode.VALIDATION_CODE_INVALID);
            return apiResult;
        }

        parkOwner.setPoPassword(SHA256Util.getSHA256String(forgetPasswordDto.getPoPassword()));
        jhkjParkOwnerMapper.updateById(parkOwner);
        return apiResult;
    }

    /**
     * 验证码
     *
     * @param phone
     * @return
     */
    @Override
    public ApiResult getCode(String phone) {
        ApiResult apiResult = new ApiResult();
        if (!checkPhoneNo(phone)) {
            apiResult.setCode(1001);
            apiResult.setError(ResultCode.valueOf(apiResult.getCode()), "手机号不合法");
        }
        Integer code = (int) ((Math.random() * 9 + 1) * 100000);
        //发送验证码
//        HttpClientUtils.doPost("http://xqpark.vaiwan.com/sms/sendMessage",code );
        Map map = new HashMap();
        map.put("phone", phone);
        map.put("content", "你本次的验证码是：" + code + ",五分钟内有效！");
        String x = HttpClientUtils.doPost(appConfig.SMSurl, map);
        template.opsForValue().set(phone, String.valueOf(code), 5, TimeUnit.DAYS);
        return apiResult;
    }


    /**
     * 校验验证码是否有效
     */
    public boolean checkVerificationCode(String userPhone, String phoneCode) {
        if (phoneCode == null || phoneCode.isEmpty()) {
            return false;
        }
        //通过手机号查询验证码
        String code = template.opsForValue().get(userPhone);
        if (code != null && code.equals(phoneCode)) {
            return true;
        }

        return false;
    }


    /**
     * 校验手机号
     */
    public boolean checkPhoneNo(String userPhone) {
        String regExp = "^((1[0-9]))\\d{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(userPhone);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
}
