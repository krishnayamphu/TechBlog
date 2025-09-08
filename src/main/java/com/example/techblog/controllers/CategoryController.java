package com.example.techblog.controllers;

import com.example.techblog.dao.PostDAO;
import com.example.techblog.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int categoryId=Integer.parseInt(req.getParameter("cat_id"));
        try {
            ArrayList<Post> posts= PostDAO.getCategoryPosts(categoryId);
            req.setAttribute("posts",posts);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("category.jsp").forward(req, res);
    }
}
