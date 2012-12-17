package com.github.bilxio.javaweb.db;

import com.github.bilxio.javaweb.AppConfig;
import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bill
 * @version 2012-12-17
 */
class DefaultDatabaseManager extends DatabaseManager {

    DefaultDatabaseManager() {
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            new SQLException(e);
        }
        return DriverManager.getConnection(AppConfig.DB_URL, AppConfig.DB_USER, AppConfig.DB_PASSWD);
    }

}
