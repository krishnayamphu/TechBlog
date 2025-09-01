package com.example.techblog.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306";
        String dbname = "blog_app";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url + "/" + dbname, user, password);
        return con;
    }
}
