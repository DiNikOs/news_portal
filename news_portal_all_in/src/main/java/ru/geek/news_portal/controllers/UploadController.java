/**
 * @Author Ostrovskiy Dmitriy
 * @Created 22/04/2020
 * UploaderController to upload files from the editor page to a folder on the server
 * @version v1.0
 */

package ru.geek.news_portal.controllers;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.PrinterStateReason;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class UploadController extends HttpServlet {

    private static String UPLOAD_DIR = "images" + File.separator + "news";

    @ResponseBody
    @RequestMapping(value = "/UploadServlet", headers = ("content-type=multipart/*"), method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void MyImageUpload(Model model, @ModelAttribute UploadForm form,
                              HttpServletRequest request,
                              HttpServletResponse response,

                              RedirectAttributes redirectAttributes) throws IOException {

       String result = null;
        try {
            result = this.saveUploadedFiles(form.getFiles(), request, response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(result);
        } finally {
            writer.close();
        }
    }

    // Save Files
    private String saveUploadedFiles(MultipartFile[] files, HttpServletRequest request,  HttpServletResponse response) throws IOException {

        StringBuilder sb = new StringBuilder();
        String userDir = null;

        try {
            if (request.authenticate(response)) {
                userDir = request.getUserPrincipal().getName();
            }
        } catch (ServletException e) {
            e.printStackTrace();
        }
        //получаем абсолютный путь к папке приложения
        String appPath = request.getServletContext().getRealPath(UPLOAD_DIR + File.separator + userDir);

        //получаем абсолютный путь к папке велосипеда
        String appPathUser = request.getServletContext().getRealPath(userDir);
//        File root = new File(appPath);
//        File  uploadDir = new File(root, userDir);

        //создаём дирректорию если нет
        File uploadDir = new File(appPath);
        while (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        //создаём дирректорию для велосипеда
        File uploadDirUser = new File(appPathUser);
        while (!uploadDirUser.exists()) {
            uploadDirUser.mkdirs();
        }

        //перебор MultipartFile (у нас 1 файл)
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }

            byte[] bytes = file.getBytes();

            String uploadFilePath = appPath + File.separator + file.getOriginalFilename();
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);

            // сохраняем файл велосипеда
            String uploadFilePathUser = appPathUser + File.separator + file.getOriginalFilename();
            Path pathUser = Paths.get(uploadFilePathUser);
            Files.write(pathUser, bytes);

            //получаем относительный путь файла
            String relativePath = userDir + File.separator + file.getOriginalFilename();
            sb.append(relativePath);
        }
        return sb.toString();
    }

}
