package com.sample.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */

@Entity
@Table(name = "ROBO_POINT")
public class RoboPoint implements RoboEntity<Long> {
    private Long id;
    private RoboUnit unit;
    private String valueType;
    private String values;

    public RoboPoint() {
    }

    public RoboPoint(RoboUnit unit, String valueType, String values) {
        this.unit = unit;
        this.valueType = valueType;
        this.values = values;
    }

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="robo_point_generator", sequenceName="robo_point_sequence", allocationSize = 1)
    @GeneratedValue(generator = "robo_point_generator")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROBO_UNIT_ID")
    public RoboUnit getUnit() {
        return unit;
    }

    public void setUnit(RoboUnit unit) {
        this.unit = unit;
    }

    @Column(name = "VALUE_TYPE")
    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    @Column(name = "VALUES")
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "RoboPoint{" +
                "id=" + id +
                ", unit=" + unit +
                ", valueType='" + valueType + '\'' +
                ", values='" + values + '\'' +
                '}';
    }
}
