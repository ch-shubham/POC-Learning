package io.shubham.service_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service2Controller {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/api/1")
    public Boolean endpoint1(){
        LOGGER.info("LOG -- 2 :::: ");
        restTemplate.getForObject("http://localhost:9999/api/2", Boolean.class);
        return false;
    }

    @GetMapping(path = "/api/2")
    public Boolean endpoint2(){
        LOGGER.info("LOG -- 4 :::: ");
        return false;
    }
}
