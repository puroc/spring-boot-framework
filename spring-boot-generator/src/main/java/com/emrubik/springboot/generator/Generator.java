package com.emrubik.springboot.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    private static void generateByTables(String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/springboot_db";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)//下划线命名
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("puroc")
                .setOutputDir("/Users/puroc/git/spring-boot-framework/spring-boot-generator/output")
                .setFileOverride(true)
                .setEnableCache(false);
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("po")
                ).execute();
    }

    public static void main(String[] args) {
        String packageName = "com.emrubik.springboot.dao";
        List<String> list = new ArrayList<String>();
        String[] tables = new String[list.size()];
        list.add("component");
        list.add("org");
        list.add("page");
        list.add("permission");
        list.add("project");
        list.add("role");
        list.add("role_premission_bind");
        list.add("tempalte");
        list.add("user");
        list.add("user_role_bind");
        list.add("user_token_bind");
        list.toArray(tables);

        generateByTables(packageName, tables);
    }
}
