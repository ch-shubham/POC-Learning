package io.shubham.service_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Service1Service {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Async("threadPoolTaskExecutor")
    public void checkTrace(){
        LOGGER.info("TRACE-2");
    }
}
