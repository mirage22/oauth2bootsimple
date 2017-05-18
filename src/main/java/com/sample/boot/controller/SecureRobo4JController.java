package com.sample.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
@Controller
@RequestMapping({"/secure"})
public class SecureRobo4JController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        return "Hello Secure Robo4J End-Point! \n";
    }
}