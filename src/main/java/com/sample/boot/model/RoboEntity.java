package com.sample.boot.model;

import java.io.Serializable;

/**
 * @author Miro Wengner (@miragemiko)
 */
public interface RoboEntity<ID> extends Serializable {

    long serialVersionUID = 1;

    ID getId();
}
