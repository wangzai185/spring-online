package com.xqtc.web.aspectj;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 操作日志记录处理
 *
 * @author zhangw
 */
@Aspect
@Component
public class WebAspect {

    private Logger logger = LoggerFactory.getLogger(WebAspect.class);

    ThreadLocal<Long>  startTime = new ThreadLocal<Long>();

    private Gson gson = new Gson();

    // 配置织入点
    @Pointcut("execution(public * com.xqtc.web.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("============================请求内容start===========================================");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("请求类方法:" + joinPoint.getSignature());
        logger.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        logger.info("============================请求内容end===========================================");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("--------------返回内容----------------");
        logger.info("Response内容:" + gson.toJson(ret));
        logger.info("--------------返回内容----------------");
        logger.info("请求处理时间为:"+(System.currentTimeMillis() - startTime.get()));
    }
//
//    /**
//     * 前置通知 用于拦截操作
//     *
//     * @param joinPoint 切点
//     */
//    @AfterReturning(pointcut = "webLog()")
//    public void doBefore(JoinPoint joinPoint) {
//        handleLog(joinPoint, null);
//    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint
     * @param e
     */
//    @AfterThrowing(value = "webLog()", throwing = "e")
//    public void doAfter(JoinPoint joinPoint, Exception e) {
//        handleLog(joinPoint, e);
//    }
//
//    protected void handleLog(final JoinPoint joinPoint, final Exception e) {
//        try {
//
//        } catch (Exception exp) {
//            // 记录本地异常日志
//            logger.error("==前置通知异常==");
//            logger.error("异常信息:{}", exp.getMessage());
//            exp.printStackTrace();
//        }
//    }


    /**
     * 是否存在注解，如果存在就获取
     */
//    private Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
//        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();
//
//        if (method != null) {
//            return method.getAnnotation(Log.class);
//        }
//        return null;
//    }
}
