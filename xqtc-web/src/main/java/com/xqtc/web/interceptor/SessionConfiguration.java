package com.xqtc.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 功能描述: 设置拦截规则
 * //TODO WebMvcConfiguration 在springboot2.0时已经过时 这里暂时使用WebMvcConfigurationSupport解决 但是对应静态资源拦截是失效的
 *
 * @param:
 * @return:
 * @auther: zhangw
 * @date: 2018/9/29 10:58
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurationSupport {

    //解决跨域
    static final String ORIGINS[] = new String[]{"GET", "POST", "PUT", "DELETE"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS)
                .maxAge(3600);
    }

    /**
     * 配置静态资源
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/mapper/system");
        /** swagger配置 */
//        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
//        addPathPatterns 用于添加拦截规则
//        excludePathPatterns 用于排除拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/xxx/login") //登录页
                .excludePathPatterns("/user/sendEmail") //发送邮箱
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/doc.html/**")
                .excludePathPatterns("/user/login"); //用户登录
        super.addInterceptors(registry);
        /** swagger配置 */

    }
}
