package com.c.pet.entity;

import java.io.Serializable;

/**
 * (TbPic)实体类
 *
 * @author makejava
 * @since 2021-01-20 11:28:38
 */
public class TbPic implements Serializable {
    private static final long serialVersionUID = 704170694288870505L;
    /**
     * 图片id
     */
    private Integer pId;
    /**
     * 图片标题
     */
    private String title;
    /**
     * 图片路径
     */
    private String url;
    /**
     * 图片类型
     */
    private String type;

    private Integer status;

    /**前端修改操作字段映射*/
    private String field;

    private String value;

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

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}