package com.lsdev.jdbc.starter;

import com.lsdev.jdbc.starter.util.ConnectionManager;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
// Простая операция
/*        String sql = """
                CREATE TABLE IF NOT EXISTS info(
                    id SERIAL PRIMARY KEY,
                    data TEXT NOT NULL
                ) ;
                """;*/

/*        String sql = """
                INSERT INTO info(data)
                VALUES ('Test 1'),
                       ('Test 2'),
                       ('Test 3'),
                       ('Test 4');
                INSERT INTO info(data)
                VALUES ('Test 1'),
                       ('Test 2'),
                       ('Test 3'),
                       ('Test 4');
                """;*/
        String sql = """
                    Update info
                    SET data = 'TestTest'
                    WHERE id = 5
                    RETURNING *;
                    """;

        try (var connection = ConnectionManager.open();
            var statement = connection.createStatement()) {
            System.out.println(connection.getSchema()); // получение текущей схемы
            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.execute(sql);
            //var executeResult = statement.executeUpdate(sql);
            System.out.println("Update count on info table: " + statement.getUpdateCount());
            System.out.println(executeResult);
        }
    }/**/
}
