package com.github.bilxio.javaweb.db;

import com.github.bilxio.javaweb.AppConfig;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Bill
 * @version 2012-12-17
 */
class PooledDatabaseManager extends DatabaseManager {

    private DataSource dataSource;

    PooledDatabaseManager() {
        PoolProperties p = new PoolProperties();
        p.setUrl(AppConfig.DB_URL);
        p.setDriverClassName(AppConfig.DB_DRIVER);
        p.setUsername(AppConfig.DB_USER);
        p.setPassword(AppConfig.DB_PASSWD);
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(200);
        p.setInitialSize(100);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        this.dataSource = datasource;
        System.out.println("app started");
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
