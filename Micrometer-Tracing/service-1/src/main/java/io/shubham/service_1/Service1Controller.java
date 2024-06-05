package io.shubham.service_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service1Controller {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Service1Service service1Services;

    @GetMapping(path = "/api/1")
    public Boolean endpoint1(){
        LOGGER.info("LOG -- 1 :::: ");
        restTemplate.getForObject("http://localhost:8888/api/1", Boolean.class);
        return false;
    }

    @GetMapping(path = "/api/2")
    public Boolean endpoint2(){
        LOGGER.info("LOG -- 3 :::: ");
        restTemplate.getForObject("http://localhost:8888/api/2", Boolean.class);
        return false;
    }

    @GetMapping(path = "/api/3")
    public Boolean endpoint3(){
        LOGGER.info("LOG -- 5 :::: ");
        test();
        return false;
    }

    public Boolean test(){
        LOGGER.info("Hello");
        return false;
    }

    @GetMapping(path = "/async/test")
    public Boolean endpointAsync()
    {
        LOGGER.info("TRACE-1");
        service1Services.checkTrace();
        return false;
    }


}
