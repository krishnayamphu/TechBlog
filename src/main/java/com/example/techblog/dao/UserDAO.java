package com.example.techblog.dao;


import com.example.techblog.config.ConnectDB;
import com.example.techblog.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static User getUser(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        Connection con= ConnectDB.connect();
        String sql="SELECT * FROM users WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            user=new User(
                    rs.getInt("id"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("created_at"));
        }
        return user;
    }
    public static User getUser(String email) throws SQLException, ClassNotFoundException {
        User user = null;
        Connection con= ConnectDB.connect();
        String sql="SELECT * FROM users WHERE email=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,email);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            user=new User(
                    rs.getInt("id"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("created_at"));
        }
        return user;
    }

    public static void update(User user) throws SQLException, ClassNotFoundException {
        Connection con=ConnectDB.connect();
        String sql="UPDATE users SET fullname=?,email=?,password=? WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,user.getFullname());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getPassword());
        ps.setInt(4,user.getId());
        ps.executeUpdate();
    }

    public static boolean auth(String email,String password) throws SQLException, ClassNotFoundException {
        boolean status=false;
        Connection con=ConnectDB.connect();
        String sql="SELECT * FROM users WHERE email=? AND password=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            status=true;
        }
        return status;
    }
}
