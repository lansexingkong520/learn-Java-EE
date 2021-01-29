package com.c.pet.entity;

import java.io.Serializable;

/**
 * (TbSubject)实体类
 *
 * @author makejava
 * @since 2021-01-20 11:28:45
 */
public class TbSubject implements Serializable {
    private static final long serialVersionUID = -82511474670981559L;
    /**
     * 项目id
     */
    private Integer suId;

    private String title;

    private String detail;

    private Float price;

    private String rep;

    private String name;

    private Integer pId;

    private String url;

    //前端修改操作字段映射
    private String field;

    private String value;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }
}