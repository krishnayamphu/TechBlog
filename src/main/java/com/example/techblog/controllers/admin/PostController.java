package com.example.techblog.controllers.admin;

import com.example.techblog.dao.CategoryDAO;
import com.example.techblog.dao.PostDAO;
import com.example.techblog.models.Category;
import com.example.techblog.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/admin/posts")
public class PostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ArrayList<Post> posts= PostDAO.getPosts();
            req.setAttribute("posts",posts);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("posts/index.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        try {
            CategoryDAO.delete(id);
            res.sendRedirect("category");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
