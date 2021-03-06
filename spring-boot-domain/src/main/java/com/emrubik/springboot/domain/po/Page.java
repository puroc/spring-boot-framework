package com.emrubik.springboot.domain.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 0:不隐藏
1:隐藏
 * </p>
 *
 * @author puroc123
 * @since 2018-09-23
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String url;
    private String component;
    private Integer hidden;
    private Integer projectId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Page{" +
        ", id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", component=" + component +
        ", hidden=" + hidden +
        ", projectId=" + projectId +
        ", timestamp=" + timestamp +
        "}";
    }
}
