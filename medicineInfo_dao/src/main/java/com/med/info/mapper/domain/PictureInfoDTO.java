package com.med.info.mapper.domain;

import java.io.Serializable;
import java.util.List;

public class PictureInfoDTO implements Serializable {

    private String name;
    private String desc;
    private List<String> picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }
}
