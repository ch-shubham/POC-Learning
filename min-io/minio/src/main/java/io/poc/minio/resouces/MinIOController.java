package io.poc.minio.resouces;

import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import io.poc.minio.domain.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MinIOController {

    @Autowired
    MinioService minioService;

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("UP");
    }

    @GetMapping("/getBucketList")
    public ResponseEntity<Integer> getBucketList() {
        Integer buckList = minioService.getBucketList();
        return buckList == -1
                ? ResponseEntity.internalServerError().body(buckList)
                : ResponseEntity.ok(buckList);
    }

}
