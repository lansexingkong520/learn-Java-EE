package com.qf.cdmr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-01-11 16:25:13
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -37281687304510826L;

    private Integer oId;
    /**
     * 留言
     */
    private String message;
    /**
     * 时间
     */
    private Date dur;
    /**
     * 地址
     */
    private Integer aId;
    /**
     * 用户
     */
    private Integer uId;
    /**
     * 图片
     */
    private Integer pId;

    private Integer suId;

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDur() {
        return dur;
    }

    public void setDur(Date dur) {
        this.dur = dur;
    }

    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

}