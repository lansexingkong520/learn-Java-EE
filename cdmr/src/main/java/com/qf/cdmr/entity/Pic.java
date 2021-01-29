package com.qf.cdmr.entity;

import java.io.Serializable;

/**
 * (Pic)实体类
 *
 * @author makejava
 * @since 2021-01-11 15:43:43
 */
public class Pic implements Serializable {
    private static final long serialVersionUID = 264088486388592541L;

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
     * 图片类型，例如轮播图
     */
    private String type;
    /**
     * 图片状态1,0
     */
    private Integer status;

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

    //前端修改操作字段映射
    private String field;

    private String value;

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