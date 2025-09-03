package com.example.techblog.controllers.admin;

import com.example.techblog.dao.CategoryDAO;
import com.example.techblog.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/admin/add-post")
public class PostAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ArrayList<Category> categories = CategoryDAO.getCategories();
            req.setAttribute("categories", categories);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("posts/create.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("title");
        String slug = req.getParameter("slug");
        String content = req.getParameter("content");
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        String thumbnail = req.getParameter("thumbnail");
        String activeParam = req.getParameter("active");
        boolean active = false;

        if (activeParam != null && activeParam.equals("1")) {
            active = true;
        }

        System.out.println(active);
//        try {
//            CategoryDAO.save(new Category(name,slug));
//            res.sendRedirect("category");
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}
