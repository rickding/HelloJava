package com.odianyun;

import org.flywaydb.core.Flyway;
import javax.sql.DataSource;

public class FlywayMigration {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void migrate() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);

        // http://casheen.iteye.com/blog/1749916
//        flyway.setSchemas("saas"); // 设置接受flyway进行版本管理的多个数据库
//        flyway.setLocations("classpath:db.migration"); // 设置flyway扫描sql升级脚本、java升级脚本的目录路径或包路径
//        flyway.setEncoding("UTF-8"); // 设置sql脚本文件的编码

        try {
            flyway.migrate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
