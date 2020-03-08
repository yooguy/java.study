package com.yooguy.java.study.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Application
 *
 * @author jihoon.yoo
 * @since 2020. 03. 08.
 */
public class Application {

    public static void main(String[] args) throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "yooguy";
        String password = "pass";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created: " + connection);
//            String sqlql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255));";
            String sql = "INSERT INTO ACCOUNT VALUES(1, 'yooguy', 'pass');";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        }

    }
}
