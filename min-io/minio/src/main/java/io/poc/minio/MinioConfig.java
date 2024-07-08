package io.poc.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Value("${minio.accessKey}")
    String accessKey;

    @Value("${minio.secretKey}")
    String secretKey;

    @Bean
    MinioClient minioClient(){
        return MinioClient.builder()
                        .endpoint("http://172.18.0.2:9000")
                        .credentials(accessKey, secretKey)
                        .build();
    }
}
