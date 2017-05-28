package com.sample.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */

@Entity(name = "ROBO_UNIT")
public class RoboUnit {

    @Id
    @SequenceGenerator(name="robo_unit_generator", sequenceName="robo_unit_sequence", allocationSize = 1)
    @GeneratedValue(generator = "robo_unit_generator")
    private Long id;
    private String uid;
    private String config;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
