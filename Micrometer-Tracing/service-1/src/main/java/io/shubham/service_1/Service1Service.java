package io.shubham.service_1;

import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Service1Service {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Tracer tracer;

    @Async("threadPoolTaskExecutor")
    public void checkTrace(){
        LOGGER.info("TRACE-2");
    }
}
