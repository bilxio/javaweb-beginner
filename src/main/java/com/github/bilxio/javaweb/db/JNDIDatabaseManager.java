package com.github.bilxio.javaweb.db;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Bill
 * @version 2012-12-17
 */
class JNDIDatabaseManager extends DatabaseManager{

    private DataSource dataSource;

    JNDIDatabaseManager() {
        try {
            Context initCtx = new javax.naming.InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/hao123");
        } catch (NamingException e) {
            throw new IllegalStateException("Can't get DS from JNDI", e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
