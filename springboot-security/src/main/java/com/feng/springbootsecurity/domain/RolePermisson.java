package com.feng.springbootsecurity.domain;

/**
 * @author admin
 * @create 2020-01-28-19:24
 */
public class RolePermisson {

    private String url;
    private String roleName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
