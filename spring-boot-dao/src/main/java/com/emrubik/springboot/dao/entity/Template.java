package com.emrubik.springboot.dao.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author puroc123
 * @since 2018-05-29
 */
public class Template extends Model<Template> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Date timestamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Template{" +
        ", id=" + id +
        ", name=" + name +
        ", timestamp=" + timestamp +
        "}";
    }
}
