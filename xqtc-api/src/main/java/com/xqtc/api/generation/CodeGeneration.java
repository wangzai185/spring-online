package com.xqtc.api.generation;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成
 */
public class CodeGeneration {

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir("E://xqCode//xqParkApp//xqtc-api//src//main//java");
        gc.setOutputDir("C://");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("zhangw");// 作者
        gc.setFileOverride(true);  //是否覆盖已有的

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUrl("jdbc:mysql://rm-bp1b18ar55oml9vj1eo.mysql.rds.aliyuncs.com/xqtc");        //生产数据库
//        dsc.setUsername("xqtc20181214dev");
//        dsc.setPassword("Jhkj@@1214@");

        dsc.setUrl("jdbc:mysql://119.3.103.37:3306/xqtc_www");                       //测试数据库
        dsc.setUsername("root");
        dsc.setPassword("Xqtc@@1111");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix(new String[]{"jhkj_"});            // 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);  // 表名生成策略
        strategy.setInclude(new String[]{"jhkj_park"});            // 需要生成的表 多张表使用,隔开
        strategy.setEntityLombokModel(true);                    //实体类使用Lombok
        strategy.setLogicDeleteFieldName("is_del");             //逻辑删除属性名
        strategy.setVersionFieldName("version");                //乐观锁属性名
        strategy.setRestControllerStyle(true);                  //使用restController
        strategy.setEntityBooleanColumnRemoveIsPrefix(false);   //is_xxx 并且类型为：tinyint 生成时变为 xxx 去掉is前缀
        strategy.setEntityBuilderModel(false);                  //是否为构建者模型
        //自定义 service 父类 默认IService
        strategy.setSuperServiceClass(null);
        //自定义 serviceImpl 父类 默认IService
        strategy.setSuperServiceImplClass(null);
        //自定义 mapper 父类 默认BaseMapper
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.xqtc.api");
        //maven分模块方式 没有controller 暂时放在vo下 粘贴出去
        pc.setController("vo");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();

    }
}
