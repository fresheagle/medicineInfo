package com.med.info.mapper.domain;

public class UserRoleDTO {

    private String roleCode;
    private String roleName;

    public UserRoleDTO() {
    }

    public UserRoleDTO(String roleCode) {
        this.roleCode = roleCode;
    }

    public UserRoleDTO(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
