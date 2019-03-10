package com.med.info.dto;

import com.med.info.domain.Miss_control_reference;

import java.util.List;

public class RefrenceDTO {


    private List<MissReferenceDTO> textcontent;
    private List<MissReferenceDTO> image;

    public List<MissReferenceDTO> getTextcontent() {
        return textcontent;
    }

    public void setTextcontent(List<MissReferenceDTO> textcontent) {
        this.textcontent = textcontent;
    }

    public List<MissReferenceDTO> getImage() {
        return image;
    }

    public void setImage(List<MissReferenceDTO> image) {
        this.image = image;
    }
}
