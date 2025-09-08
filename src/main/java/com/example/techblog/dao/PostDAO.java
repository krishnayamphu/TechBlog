package com.example.techblog.dao;


import com.example.techblog.config.ConnectDB;
import com.example.techblog.models.Category;
import com.example.techblog.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO {
    public static Post getPost(int id) throws SQLException, ClassNotFoundException {
        Post post=null;
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM posts WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setSlug(rs.getString("slug"));
            post.setContent(rs.getString("content"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setThumbnail(rs.getString("thumbnail"));
            post.setActive(rs.getBoolean("active"));
            post.setCreatedAt(rs.getString("created_at"));
            post.setUpdatedAt(rs.getString("updated_at"));
        }
        return post;
    }
    public static Post getPost(String slug) throws SQLException, ClassNotFoundException {
        Post post=null;
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM posts WHERE slug=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, slug);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setSlug(rs.getString("slug"));
            post.setContent(rs.getString("content"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setThumbnail(rs.getString("thumbnail"));
            post.setActive(rs.getBoolean("active"));
            post.setCreatedAt(rs.getString("created_at"));
            post.setUpdatedAt(rs.getString("updated_at"));
        }
        return post;
    }

    public static ArrayList<Post> getPosts() throws SQLException, ClassNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM posts";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setSlug(rs.getString("slug"));
            post.setContent(rs.getString("content"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setThumbnail(rs.getString("thumbnail"));
            post.setActive(rs.getBoolean("active"));
            post.setCreatedAt(rs.getString("created_at"));
            post.setUpdatedAt(rs.getString("updated_at"));
            posts.add(post);
        }
        return posts;
    }
    public static ArrayList<Post> getRecentPosts(int count) throws SQLException, ClassNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM posts";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setSlug(rs.getString("slug"));
            post.setContent(rs.getString("content"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setThumbnail(rs.getString("thumbnail"));
            post.setActive(rs.getBoolean("active"));
            post.setCreatedAt(rs.getString("created_at"));
            post.setUpdatedAt(rs.getString("updated_at"));
            posts.add(post);
        }
        return posts;
    }
    public static ArrayList<Post> getCategoryPosts(int id) throws SQLException, ClassNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();
        Connection con = ConnectDB.connect();
        String sql = "SELECT * FROM posts WHERE category_id=? ORDER BY id DESC";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setSlug(rs.getString("slug"));
            post.setContent(rs.getString("content"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setThumbnail(rs.getString("thumbnail"));
            post.setActive(rs.getBoolean("active"));
            post.setCreatedAt(rs.getString("created_at"));
            post.setUpdatedAt(rs.getString("updated_at"));
            posts.add(post);
        }
        return posts;
    }

    public static void save(Post post) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.connect();
        String sql = "INSERT INTO posts (title,slug,content,category_id,thumbnail,active) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, post.getTitle());
        ps.setString(2, post.getSlug());
        ps.setString(3, post.getContent());
        ps.setInt(4, post.getCategoryId());
        ps.setString(5, post.getThumbnail());
        ps.setBoolean(6, post.isActive());
        ps.executeUpdate();
    }

    public static void update(Category category) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.connect();
        String sql = "UPDATE category SET name=?,slug=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, category.getName());
        ps.setString(2, category.getSlug());
        ps.setInt(3, category.getId());
        ps.executeUpdate();
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.connect();
        String sql = "DELETE FROM category WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
