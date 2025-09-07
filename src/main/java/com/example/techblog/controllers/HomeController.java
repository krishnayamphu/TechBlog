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

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            ArrayList<Post> posts= PostDAO.getPosts();
            req.setAttribute("posts",posts);

            for (Post post : posts) {
                System.out.println(post.getTitle());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("home.jsp").forward(req, res);
    }
}
