package com.example.techblog.controllers;

import com.example.techblog.util.MailHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/contact")
public class ContactController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("contact.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String to ="krishnayamphu@gmail.com";
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String subject=req.getParameter("subject");
        String message=req.getParameter("msg");

        MailHelper.sendEmail(to,name,subject,email,message);
        HttpSession session=req.getSession();
        session.setAttribute("success","Message sent!");
        res.sendRedirect(req.getHeader("referer"));
    }
}
