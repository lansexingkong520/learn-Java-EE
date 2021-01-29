package com.qf.cdmr.entity;

import java.io.Serializable;

/**
 * (Subject)实体类
 *
 * @author makejava
 * @since 2021-01-11 16:26:42
 */
public class Subject implements Serializable {
    private static final long serialVersionUID = 318432393850992504L;

    private Integer suId;
    /**
     * 项目标题
     */
    private String title;
    /**
     * 项目描述
     */
    private String desc;
    /**
     * 项目价格
     */
    private Float price;
    /**
     * 项目详情
     */
    private String detail;

    private String name;

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}