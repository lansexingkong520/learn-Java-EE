package com.c.pet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbCourse)实体类
 *
 * @author makejava
 * @since 2021-01-20 11:30:13
 */
public class TbCourse implements Serializable {
    private static final long serialVersionUID = -42854609418056483L;

    private Integer cId;
    /**
     * 课程内容
     */
    private String message;
    /**
     * 课程图片
     */
    private Integer pId;
    /**
     * 课程题目
     */
    private String title;
    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private String url;

    //前端修改操作字段映射
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}