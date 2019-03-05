package com.example.demo.bean;

import org.springframework.web.multipart.MultipartFile;

public class DemoDTO {

    private String projectId;

    private String context;

    private MultipartFile file;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
