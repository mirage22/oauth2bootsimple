package com.sample.boot.repository;

import com.sample.boot.model.RoboUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
@Repository
public interface RoboUnitRepository  extends CrudRepository<RoboUnit, Long> {
}
