package com.lsdev.jdbc.starter;

import com.lsdev.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;

        try (var connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        }
    }
}
