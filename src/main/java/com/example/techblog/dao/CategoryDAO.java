package com.example.techblog.dao;


import com.example.techblog.config.ConnectDB;
import com.example.techblog.models.Category;
import com.example.techblog.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {
    public static Category getCategory(int id) throws SQLException, ClassNotFoundException {
        Category category = null;
        Connection con= ConnectDB.connect();
        String sql="SELECT * FROM category WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            category=new Category(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("slug"),
                    rs.getString("created_at"),
                    rs.getString("updated_at"));
        }
        return category;
    }

    public static ArrayList<Category> getCategories() throws SQLException, ClassNotFoundException {
        ArrayList<Category> categories=new ArrayList<>();
        Connection con= ConnectDB.connect();
        String sql="SELECT * FROM category";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
           categories.add(new Category(
                   rs.getInt("id"),
                   rs.getString("name"),
                   rs.getString("slug"),
                   rs.getString("created_at"),
                   rs.getString("updated_at")));
        }
        return categories;
    }

    public static void save(Category category) throws SQLException, ClassNotFoundException {
        Connection con=ConnectDB.connect();
        String sql="INSERT INTO category (name,slug) VALUES (?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,category.getName());
        ps.setString(2,category.getSlug());
        ps.executeUpdate();
    }
    public static void update(Category category) throws SQLException, ClassNotFoundException {
        Connection con=ConnectDB.connect();
        String sql="UPDATE category SET name=?,slug=? WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,category.getName());
        ps.setString(2,category.getSlug());
        ps.setInt(3,category.getId());
        ps.executeUpdate();
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException {
        Connection con=ConnectDB.connect();
        String sql="DELETE FROM category WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
}
