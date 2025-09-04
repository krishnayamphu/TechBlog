package com.example.techblog.controllers.media;

import com.example.techblog.util.MediaHelper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/admin/media")
public class MediaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("files", MediaHelper.getMediaFiles());
        req.getRequestDispatcher("media/index.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void processUploadedFile(FileItem item) {
        String fileName = item.getName();
        File path = new File("C:\\uploads");
        if (!path.exists()) {
            path.mkdirs();
        }
        File uploadedFile = new File(path + "/" + fileName);
        try {
            item.write(uploadedFile);
            System.out.println("File Uploaded to :" + uploadedFile.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
