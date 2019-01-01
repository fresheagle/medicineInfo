package com.med.info.mapper.domain;

import java.io.Serializable;

public class UserInfoDTO implements Serializable {


    private String userCode;
    private String userName;

    public UserInfoDTO(String userCode) {
        this.userCode = userCode;
    }

    public UserInfoDTO(String userCode, String userName) {
        this.userCode = userCode;
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
