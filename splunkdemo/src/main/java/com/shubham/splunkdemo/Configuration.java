package com.shubham.splunkdemo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

// runs before everything before the tomcat server starts.
@org.springframework.context.annotation.Configuration
public class Configuration {
 private static final Logger log = LoggerFactory.getLogger(Configuration.class);

 @Bean
 void preRunFunction(){
  log.info("Pre run function in Configuration.");
 }

}
