package com.qf.cdmr.entity;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2021-01-11 15:57:33
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 442676204504225909L;

    private Integer uId;

    private String username;

    private String password;
    /**
     * 用户头像
     */
    private Integer pId;


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