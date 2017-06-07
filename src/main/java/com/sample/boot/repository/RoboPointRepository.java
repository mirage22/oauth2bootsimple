package com.sample.boot.repository;

import com.sample.boot.model.RoboPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
@Repository
public interface RoboPointRepository extends CrudRepository<RoboPoint, Long> {
}
