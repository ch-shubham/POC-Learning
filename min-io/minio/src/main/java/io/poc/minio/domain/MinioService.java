package io.poc.minio.domain;

import io.minio.MinioClient;
import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinioService {

    @Autowired
    MinioClient minioClient;

    public Integer getBucketList(){
        try{
            return minioClient.listBuckets().size();
        }catch (Exception ex){
            System.out.println(ex);
            return -1;
        }
    }


}
