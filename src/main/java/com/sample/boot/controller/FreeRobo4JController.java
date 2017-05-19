package com.sample.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Miro Wengner (@miragemiko)
 */
@Controller
@RequestMapping({"/free"})
public class FreeRobo4JController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        return "Hello Free Robo4J End-Point! \n";
    }
}