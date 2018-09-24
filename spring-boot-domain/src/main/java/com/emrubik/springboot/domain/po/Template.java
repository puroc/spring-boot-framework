package com.emrubik.springboot.domain.po;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author puroc123
 * @since 2018-09-23
 */
public class Template implements Serializable {

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
    public String toString() {
        return "Template{" +
        ", id=" + id +
        ", name=" + name +
        ", timestamp=" + timestamp +
        "}";
    }
}
