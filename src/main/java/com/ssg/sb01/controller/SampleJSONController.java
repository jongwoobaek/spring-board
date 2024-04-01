package com.ssg.sb01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleJSONController {

    @GetMapping("/api/helloArr")
    public String[] hello() {
        log.info("helloArr...!!!");

        return new String[]{"Hello", "Springboot", "nice to meet you"};
    }
}
