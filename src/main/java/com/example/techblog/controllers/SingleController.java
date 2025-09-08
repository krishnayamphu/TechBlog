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

@WebServlet("/post")
public class SingleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String slug=req.getParameter("slug");
        try {
            Post post= PostDAO.getPost(slug);
            req.setAttribute("post",post);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("single.jsp").forward(req, res);
    }
}
