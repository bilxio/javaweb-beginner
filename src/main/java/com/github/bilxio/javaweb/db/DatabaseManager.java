package com.github.bilxio.javaweb.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Bill
 * @version 2012-12-17
 */
public abstract class DatabaseManager {

    public abstract Connection getConnection() throws SQLException;

    static void setInstance(DatabaseManager instance) {
        PooledDatabaseManager.instance = instance;
    }

    public static DatabaseManager instance;

}
