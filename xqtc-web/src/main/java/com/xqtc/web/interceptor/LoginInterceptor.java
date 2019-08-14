package com.xqtc.web.interceptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xqtc.api.entity.BusinessEntity;
import com.xqtc.api.service.BusinessService;
import com.xqtc.common.utils.SHA256Util;
import com.xqtc.common.utils.StringUtils;
import com.xqtc.common.utils.bean.SpringBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 功能描述: 拦截器
 *
 * @auther: zhangw
 * @date: 2018/9/29 10:58
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    private String common_account = "xqtc _account";

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Gson gson = new GsonBuilder().serializeNulls().enableComplexMapKeySerialization().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        Map parameterMap = request.getParameterMap();

        log.info(" 请求地址为: " + request.getServletPath() + " 请求参数为: " + gson.toJson(parameterMap));
        try {
//            if (request.getParameter("sign").equals(common_account)) {         //测试绿色通道
//                return true;
//            }
//            //获取请求参数
//            //校验时间
//            String timeParam = request.getParameter("timeStamp");
//            long timeStamp = Long.parseLong(timeParam);
//            Long SystemTime = (new Date().getTime() - timeStamp) / (1000 * 60);
//            if (StringUtils.isEmpty(timeParam) || SystemTime > 1) {
//                response.setStatus(81007);
//                response.sendError(81007, "timeStamp不能为空或已过期！请检查！");
//                return false;
//            }
//            //验证参数
//            String accessKey = request.getParameter("accessKey");
//            if (StringUtils.isEmpty(accessKey)) {
//                //公钥不存在
//                response.setStatus(81001);
//                response.sendError(81001, "accessKey不能为空！");
//                return false;
//            }
//            if (StringUtils.isEmpty(request.getParameter("nonce"))) {
//                //随机数不存在
//                response.setStatus(81002);
//                response.sendError(81002, "nonce不能为空！");
//                return false;
//            }
//            String paramSign = request.getParameter("sign");
//            if (StringUtils.isEmpty(paramSign)) {
//                //签名不存在
//                response.setStatus(81003);
//                response.sendError(81003, "签名不能为空！");
//                return false;
//            }
//            BusinessService businessService = SpringBeanUtil.getBean("businessServiceImpl");
//            BusinessEntity business = businessService.selectOne(accessKey);
//            String systemSign = null;
//            if (business != null) {
//                String secretKey = business.getSecretKey();
//                Map<String, String[]> map = new HashMap<>(parameterMap);
//                systemSign = createSign(map,secretKey);
//            } else {
//                response.setStatus(81004);
//                response.sendError(81004, "公钥有误,请检查！");
//                return false;
//            }
//           // 加密 公钥+私钥+参数
//            if (!systemSign.equals(paramSign) || !StringUtils.equals(systemSign, paramSign)) {
//                response.setStatus(81005);
//                response.sendError(81005, "签名有误,请检查！");
//                return false;
//            }
//            String signxxx = request.getParameter("sign");
//            Map<String, String[]> map = new HashMap<>(parameterMap);
//            String mySign = createSign(map,"3e06TcvI7SqI9Kny");
//            if (!signxxx.equals(mySign)|| !StringUtils.equals(signxxx,mySign)){
//                System.err.println(signxxx + "================签名有误=========================" + mySign);
//                response.setStatus(81005);
//                response.sendError(81005, "签名有误,请检查！");
//                return false;
//            }else {
//                System.err.println(signxxx + "================签名校验成功=========================" + mySign);
//            }
        } catch (Exception e) {
            log.error(e.toString());
            response.setStatus(500);
            response.sendError(500, "请求异常! ");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String C = "poPassword=e10adc3949ba59abbe56e057f20f883e&poPhone=18552456191&poPhoneType=1&secretKey=3e06TcvI7SqI9Kny";
        System.err.println(C.toUpperCase());
//            "sign":["5a7917477bed41f8bea67db129a2a648daa7da3c8b70f1d62f72323a23f52ea9"]}
        Map <String,String[]>map = new HashMap();
//        String[]accessKey = {"xqtc6f5ce1b4"};
//        String[]timeStamp = {"1563191843820"};
//        String[]secretKey = {"3e06TcvI7SqI9Kny"};
        String[]poPhone = {"18552456192"};
        String[]poPassword = {"123456"};
        String[]poPhoneType = {"1"};
//        map.put("accessKey",accessKey);
//        map.put("timeStamp", timeStamp);
//        map.put("secretKey",secretKey);
        map.put("poPhone",poPhone);
        map.put("poPassword",poPassword);
        map.put("poPhoneType",poPhoneType);
        String sign = createSign(map, "3e06TcvI7SqI9Kny");
        System.err.println("sign============" + sign);
    }


    private static String createSign(Map<String, String[]> params, String secretKey) {
        params.remove("sign");
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuilder temp = new StringBuilder();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            String[] values = params.get(key);
            String value = "";
            if (null != values) {
                value = Arrays.toString(values);
                value = value.substring(1, value.length() - 1);
            }
            temp.append(key).append("=").append(value);
        }
        temp.append("&").append("secretKey").append("=").append(secretKey);
        System.err.println(temp.toString());
        return SHA256Util.getSHA256String(temp.toString().toUpperCase());
    }
}
