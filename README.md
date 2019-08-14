# **小强停车App后端代码基本架构**

#### 项目为maven多模块结构 尽量松耦合，方便模块升级、增减模块：
```
    xqparkApp                        //父级模块
        |
        xqtc-api                     // 接口层 用于存放实体类 Mapper service等 接口声明 mybatis逆向生成
        |    |
        |    resource                //全局配置文件 maven多环境配置 日志配置 mybatis中mapper.xml等
        |      |
        |       application.yml    
        |       application.dev.yml
        |       application.prd.yml
        |
        |
        |
        xqtc-web    
             |
             docker                  //docker相关配置文件
             |
             interceptor             //拦截器相关  拦截接口请求 请求验签等
             |
             controller              // 控制器 
             |
             aspectj                 //每次请求日志拦截 包括请求路径 参数 以及返回结果； 事务控制 切点形式管理事务
             |
             XqParkApplication       //启动类
             XqParkServletInitializer   //war包启动方式
             
```

#### 1. **技术选型**
 + Java EE 8
 + Servlet 3.0
 + Apache Maven 3 
#### 2. 主框架
 + Spring Boot 2.0
 + Spring Framework 5.0
#### 3. 持久层
 + MyBatis-plus  3.0
 + Alibaba Druid 1.1
 + mysql 5.5+

## 运行系统
 1. 前往GitLab下载页面(git@hw.xqpark.cn:zhangw/xqpark-app.git)下载到工作目录
 
 2. 导入到IDE，菜单 File -> Open，然后选择工作目录，然后点击 OK 按钮，即可成功导入。idea/Eclipse会自动加载Maven依赖包，初次加载会比较慢（根据自身网络情况而定）

 3. 创建数据库ry并导入数据脚本ry_20190215.sql，quartz.sql
 
 4. 打开运行com.xqtc.XqParkApplication.java
 
 5. 打开浏览器，输入：http://localhost:8099/swagger-ui.html
      若能正确展示接口文档页面，则表明环境搭建成功
## 部署系统
 1. 使用maven打包 输入命令：clean package -D maven.test.skip=true -P dev 
                           clean package -D maven.test.skip=true -P test
                           clean package -D maven.test.skip=true -P prd
 2. 所有模块均显示SUCCESS表示成功编译 在xqtc-web 模块下有target文件夹下xqtc-web-3.0.jar 打包完成
 
 3. 上传此jar包至服务器任意目录下  运行 nohup java -jar xqtc-web-3.0.jar &  至此部署完成

 4. 后续会有docker打包 暂时还未集成
 
#### 相关技术应用方式：

##### swagger自动化文档访问： 启动项目主机ip + swagger-ui.html  示例： http://127.0.0.1:8099/swagger-ui.html 

##### Druid监控访问： 启动项目主机ip + /druid/index.html       示例： http://127.0.0.1:8099/druid/index.html  

##### redis ：采用lettuce连接池技术 底层采用netty实现 比jedis性能更优

##### mybatis-plus : 使用mybatis plus 做持久化框架 集成通用mapper 减少手写SQL  具体使用方式参照：https://mp.baomidou.com/guide/wrapper.html#abstractwrapper自行查阅 

##### swagger 相关注解使用说明：
```
          1.  @Api：用在请求的类上，说明该类的作用  
          
                        示例：@Api(tags="APP用户注册Controller")
              
          2.  @ApiOperation：用在请求的方法上，说明方法的作用
          
                        示例：@ApiOperation(value="用户注册",notes="手机号、密码都是必输项，年龄随边填，但必须是数字")
          
          3.  @ApiImplicitParams：用在请求的方法上，包含一组参数说明
          
                        示例：@ApiImplicitParams({@ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
                                                   @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
                                                   @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")}) 
                                     
          4.  @ApiResponses：用于请求的方法上，表示一组响应  @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
                        
                        示例：@ApiResponses({
                               @ApiResponse(code=400,message="请求参数没填好"),
                               @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
                           })

          5. @ApiModel：用于响应类上，表示一个返回响应数据的信息    @ApiModelProperty：用在属性上，描述响应类的属性
          
                         示例：@ApiModel(description= "返回响应数据")
                            public class RestMessage implements Serializable{
                             
                                @ApiModelProperty(value = "是否成功")
                                private boolean success=true;
                                @ApiModelProperty(value = "返回对象")
                                private Object data;
                                @ApiModelProperty(value = "错误编号")
                                private Integer errCode;
                                @ApiModelProperty(value = "错误信息")
                                private String message;
                                /* getter/setter */
                            }
                      
```
## springboot监控：
## 启动项目之后 访问： 主机名 + /actuator+    示例： http://127.0.0.1:8099/actuator/health 
+ /health            健康度信息
+ /info 　　　　　　　应用基本信息
+ /metrics 　　　　　 运行指标
+ /env 　　　　　　　 环境变量信息
+ /loggers 　　　　　 日志相关
+ /dump 　　　　　  　线程相关信息
+ /trace 　　　　　　 请求调用轨迹
+ /metrics           展示当前应用的metrics信息
+ /mappings          显示一个所有@RequestMapping路径的集合列表
+ /sessions          允许从Spring会话支持的会话存储中检索和删除(retrieval and deletion)用户会话。使用Spring Session对反应性Web应用程序的支持时不可用。
+ /shutdown          允许应用以优雅的方式关闭（默认情况下不启用）
+ /threaddump        执行一个线程dump	
+ /beans             显示一个应用中所有Spring Beans的完整列表
+ /auditevents       显示当前应用程序的审计事件信息
+ /conditions        显示配置类和自动配置类(configuration and auto-configuration classes)的状态及它们被应用或未被应用的原因
+ /configprops       显示一个所有@ConfigurationProperties的集合列表