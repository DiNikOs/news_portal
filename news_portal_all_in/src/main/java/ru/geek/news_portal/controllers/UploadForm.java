/**
 * @Author Ostrovskiy Dmitriy
 * @Created 22/04/2020
 * UploadForm to transfer a file from a view to the controller
 * @version v1.0
 */


package ru.geek.news_portal.controllers;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

    private String description;

    private MultipartFile[] files;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

}