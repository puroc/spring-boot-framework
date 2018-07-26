package com.emrubik.springboot.dao.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author puroc123
 * @since 2018-07-25
 */
public class Component extends Model<Component> {

    private static final long serialVersionUID = 1L;

    private String id;
    private Integer pageId;
    private String name;
    private String type;
    private String attributes;
    private String codes;
    private String datas;
    private String events;
    private String layout;
    private String params;
    private String styles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Component{" +
        ", id=" + id +
        ", pageId=" + pageId +
        ", name=" + name +
        ", type=" + type +
        ", attributes=" + attributes +
        ", codes=" + codes +
        ", datas=" + datas +
        ", events=" + events +
        ", layout=" + layout +
        ", params=" + params +
        ", styles=" + styles +
        "}";
    }
}
