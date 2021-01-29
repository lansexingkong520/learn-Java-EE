package com.qf.cdmr.entity;

import java.io.Serializable;

/**
 * (Shop)实体类
 *
 * @author makejava
 * @since 2021-01-11 15:53:09
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = -57904858218975803L;

    private Integer sId;
    /**
     * 商铺描述
     */
    private String desc;


    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}