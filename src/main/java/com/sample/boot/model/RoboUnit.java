package com.sample.boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */

@Entity
public class RoboUnit {

    @Id
    private Integer id;
    private String uid;
    private String config;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "RoboUnit{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", config='" + config + '\'' +
                '}';
    }
}
