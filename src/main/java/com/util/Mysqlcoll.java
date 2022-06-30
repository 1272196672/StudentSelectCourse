package com.util;

import java.io.InputStream;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
public class Mysqlcoll {
    private static DataSource dataSource = null;
    static {
        try {
            Properties properties = new Properties();
            InputStream ins = Mysqlcoll.class.getClassLoader().getResourceAsStream
                    ("MyJDBC.properties");
            properties.load(ins);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JdbcTemplate getTmp(){
        return new JdbcTemplate(dataSource);
    }
}
