package com.sample.boot;

import com.sample.boot.config.ApplicationConfig;
import com.sample.boot.model.RoboPoint;
import com.sample.boot.model.RoboUnit;
import com.sample.boot.repository.RoboPointRepository;
import com.sample.boot.repository.RoboUnitRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author Miro Wengner (@miragemiko)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(ApplicationConfig.class)
public class OAuth2ApplicationTest {

    private  static final String CAMERA_UNIT = "cameraUnit";
    private static final String HTTP_UNIT = "httpUnit";

    @Autowired
    private RoboUnitRepository unitRepository;

    @Autowired
    private RoboPointRepository pointRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    public void testRepository(){
        RoboUnit mainUnit = new RoboUnit();
        mainUnit.setUid("main");
        mainUnit.setConfig("cameraUnit,httpUnit,mainConfiguration");

        RoboUnit cameraUnit = new RoboUnit();
        cameraUnit.setUid(CAMERA_UNIT);
        cameraUnit.setConfig("jpg,5ms");
        cameraUnit.setParent(mainUnit);

        RoboUnit httpUnit = new RoboUnit();
        httpUnit.setUid(HTTP_UNIT);
        httpUnit.setParent(mainUnit);
        httpUnit.setConfig("serverIp:port/end_point");
        List<RoboPoint> roboPoints = Arrays.asList(
                new RoboPoint(httpUnit, "image1", "img1,img2"),
                new RoboPoint(httpUnit, "image2", "img1,img2"));
        httpUnit.addPoints(roboPoints);


        mainUnit.addPart(cameraUnit);
        mainUnit.addPart(httpUnit);
        unitRepository.save(mainUnit);

        List<RoboUnit> units = (List<RoboUnit>) unitRepository.findAll();
        RoboUnit tmpCameraUnitStored = unitRepository.findByUid(CAMERA_UNIT);
        RoboUnit tmpHttpUnitStored = unitRepository.findByUid(HTTP_UNIT);

        Assert.assertNotNull(units);
        Assert.assertTrue(units.size() == 3);
        Assert.assertNotNull(tmpHttpUnitStored.getPoints());
        Assert.assertTrue(tmpHttpUnitStored.getPoints().size() == 2);

    }

}
