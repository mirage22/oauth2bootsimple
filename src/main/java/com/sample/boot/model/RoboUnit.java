package com.sample.boot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */

@Entity(name = "ROBO_UNIT")
public class RoboUnit implements RoboEntity<Long>{

    private Long id;
    private String uid;
    private String config;
    private RoboUnit parent;
    private List<RoboUnit> parts;
    private List<RoboPoint> points;

    public RoboUnit() {
        this.parts = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="robo_unit_generator", sequenceName="robo_unit_sequence", allocationSize = 1)
    @GeneratedValue(generator = "robo_unit_generator")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "UID")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Column(name = "CONFIG")
    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARENT_ID")
    public RoboUnit getParent() {
        return parent;
    }

    public void setParent(RoboUnit parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    public List<RoboUnit> getParts() {
        return parts;
    }

    public void setParts(List<RoboUnit> parts) {
        this.parts = parts;
    }

    public void addPart(RoboUnit unit) {
        this.parts.add(unit);
    }

    public void addParts(List<RoboUnit> units) {
        this.parts.addAll(units);
    }

    @OneToMany(mappedBy = "unit", fetch = FetchType.EAGER)
    public List<RoboPoint> getPoints() {
        return points;
    }

    public void setPoints(List<RoboPoint> points) {
        this.points = points;
    }

    public void addPoint(RoboPoint point) {
        this.points.add(point);
    }

    public void addPoints(List<RoboPoint> points) {
        this.points.addAll(points);
    }

    @Override
    public String toString() {
        return "RoboUnit{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", config='" + config + '\'' +
                ", parent=" + parent +
                ", parts=" + parts.stream().map(RoboUnit::getUid).collect(Collectors.toList()) +
                ", points=" + points.stream().map(RoboPoint::getValueType).collect(Collectors.toList()) +
                '}';
    }
}
