package com.github.bilxio.javaweb.db;

import com.github.bilxio.javaweb.AppConfig;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Bill
 * @version 2012-12-06
 */
public class DatabaseManagerInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseManager.setInstance(new DefaultDatabaseManager());
        System.out.println("DatabaseManager initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
