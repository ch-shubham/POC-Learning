package com.shubham.splunkdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/health")
    String health(){
        log.info("INFO :: Health OK");
        log.debug("DEBUG :: Health OK");
        log.warn("WARN :: Health OK");
        log.error("ERROR :: Health OK");
        return "OK.";
    }

}
