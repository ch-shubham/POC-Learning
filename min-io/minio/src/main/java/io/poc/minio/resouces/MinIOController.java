package io.poc.minio.resouces;

import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import io.poc.minio.domain.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping("/getBuckets")
    public ResponseEntity<Integer> getBucketList() {
        Integer buckList = minioService.getBucketList();
        return buckList == -1
                ? ResponseEntity.internalServerError().body(buckList)
                : ResponseEntity.ok(buckList);
    }

    @GetMapping("/getBucketsNames")
    public ResponseEntity<ArrayList<String>> getBucketsName(){
        ArrayList<String> getNamesOfAllBuckets = minioService.getAllBucketsName();
        return ResponseEntity.ok(getNamesOfAllBuckets);
    }

    @PostMapping("/create-bucket")
    public ResponseEntity<String> createBucket(@RequestParam(name = "bucketName") String bucketName){
        String result = minioService.createBucket(bucketName);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadToMinio(
//            @RequestParam(name = "bucketName") String bucketName
            @RequestParam("file") MultipartFile file
    ){
        String bucketName = "swaggerkibucket"; // todo Get it from parameter.


        String uploadToMinio = minioService.uploadToMinio(bucketName, file);
        return ResponseEntity.ok(uploadToMinio);
    }
}
