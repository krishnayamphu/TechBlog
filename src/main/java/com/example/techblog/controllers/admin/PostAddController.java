package com.example.techblog.controllers.admin;

import com.example.techblog.dao.CategoryDAO;
import com.example.techblog.dao.PostDAO;
import com.example.techblog.models.Category;
import com.example.techblog.models.Post;
import com.example.techblog.util.MediaHelper;

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
            req.setAttribute("files", MediaHelper.getMediaFiles());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("posts/create.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String slug = req.getParameter("slug");
        String content = req.getParameter("content");
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        String thumbnail = req.getParameter("thumbnail");
        String activeParam = req.getParameter("active");
        boolean active = false;

        if (activeParam != null && activeParam.equals("1")) {
            active = true;
        }
        try {
            Post post=new Post();
            post.setTitle(title);
            post.setSlug(slug);
            post.setContent(content);
            post.setCategoryId(category_id);
            post.setThumbnail(thumbnail);
            post.setActive(active);
            PostDAO.save(post);
            res.sendRedirect("posts");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
