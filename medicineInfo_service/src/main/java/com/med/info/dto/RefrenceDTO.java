package com.med.info.dto;

import com.med.info.domain.Miss_control_reference;

import java.util.List;

public class RefrenceDTO {

    private List<Miss_control_reference> textcontent;
    private List<Miss_control_reference> image;

    public List<Miss_control_reference> getTextcontent() {
        return textcontent;
    }

    public void setTextcontent(List<Miss_control_reference> textcontent) {
        this.textcontent = textcontent;
    }

    public List<Miss_control_reference> getImage() {
        return image;
    }

    public void setImage(List<Miss_control_reference> image) {
        this.image = image;
    }
}
