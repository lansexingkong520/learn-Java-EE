package com.c.pet.entity;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2021-01-20 11:28:51
 */
public class TbUser implements Serializable {
    private static final long serialVersionUID = -51498193126267095L;
    /**
     * 用户id
     */
    private Integer uId;
    /**
     * 用户名字
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;

    private Integer pId;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

}