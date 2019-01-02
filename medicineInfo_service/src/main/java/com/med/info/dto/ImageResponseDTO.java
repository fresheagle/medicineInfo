package com.med.info.dto;

import java.io.Serializable;

public class ImageResponseDTO implements Serializable {

    private String name;
    private String originalUrl;
    private String thumbnailUrl;

    public ImageResponseDTO(String name, String originalUrl, String thumbnailUrl) {
        this.name = name;
        this.originalUrl = originalUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    public ImageResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
