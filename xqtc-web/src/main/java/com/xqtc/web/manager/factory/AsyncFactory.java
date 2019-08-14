package com.xqtc.web.manager.factory;

import com.xqtc.api.entity.SysOperLog;
import com.xqtc.api.service.ISysOperLogService;
import com.xqtc.common.constant.Constants;
import com.xqtc.common.utils.*;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author zhangw
 */
public class AsyncFactory {
    private static final Logger logger = LoggerFactory.getLogger("sys-user");

    /**
     * 操作日志记录
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }

    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(HttpServletRequest request, final String username, final String status, final String message, final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(request);
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                System.err.println("登录信息======userName："+username+"Ip: "+ip+"  address: "+address+" browser: "+ browser+" os: "+os+" message: "+message+"============");
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                    logger.info(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    logger.info(Constants.FAIL);
                }
                // TODO 后续有必要做插入数据
                logger.info("登录信息======userName："+username+"Ip: "+ip+"  address: "+address+" browser: "+ browser+" os: "+os+" message: "+message+"===================");
            }
        };
    }
}
