package io.shubham.configurationsvc;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableEncryptableProperties
public class ConfigurationsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationsvcApplication.class, args);
	}

}
