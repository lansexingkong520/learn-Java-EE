package com.c.pet.entity;

import java.io.Serializable;

/**
 * (TbOrder)实体类
 *
 * @author makejava
 * @since 2021-01-20 11:30:25
 */
public class TbOrder implements Serializable {
    private static final long serialVersionUID = -23730366735220162L;

    private Integer oId;

    private Integer uId;

    private Integer suId;
    /**
     * 预约时间
     */
    private Object dur;
    /**
     * 留言
     */
    private String message;
    /**
     * 用户真实名字
     */
    private String uname;
    /**
     * 电话
     */
    private String tel;
    /**
     * 项目名字
     */
    private String suname;

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }

    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public Object getDur() {
        return dur;
    }

    public void setDur(Object dur) {
        this.dur = dur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}