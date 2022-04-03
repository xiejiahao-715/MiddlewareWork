package com.xjh.middlewarework.work2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/middleware_homework?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123456";


    public static Connection getConnection(){
        Connection connection = null;
        try {
            // 注册驱动
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
