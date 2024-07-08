package io.poc.minio.resouces;

import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Bucket;
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
    MinioClient minioClient;

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("UP");
    }

    @GetMapping("/getBucketList")
    public ResponseEntity<Integer> getBucketList() {
        try{
            List<Bucket> bucketList = minioClient.listBuckets();
            return ResponseEntity.ok(bucketList.size());

        }
        catch (Exception err){
            System.out.println("------------------------");
            System.out.println(err);
            System.out.println("------------------------");
            return ResponseEntity.internalServerError().body(-1);
        }
    }
}
