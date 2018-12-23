package com.med.info.dto;

import java.io.Serializable;

public class ImageResponseDTO implements Serializable {

    private String name;
    private String url;

    public ImageResponseDTO() {
    }

    public ImageResponseDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
