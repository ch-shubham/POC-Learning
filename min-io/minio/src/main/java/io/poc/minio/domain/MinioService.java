package io.poc.minio.domain;

import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class MinioService {

    @Autowired
    MinioClient minioClient;

    public Integer getBucketList() {
        try {
            return minioClient.listBuckets().size();
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }


    public ArrayList<String> getAllBucketsName() {
        try {
            List<Bucket> bucketList = minioClient.listBuckets();
            ArrayList<String> namesOfBuckets = new ArrayList<>();
            for (Bucket bucket : bucketList) {
                namesOfBuckets.add(bucket.creationDate() + ", " + bucket.name());
            }
            return namesOfBuckets;
        } catch (Exception ex) {
            System.out.println(ex);
            return new ArrayList<>() {{
                add("ERROR RECEIVED, UNABLE TO FETCH NAMES");
            }};
        }

    }

    public String uploadToMinio(String bucketName, MultipartFile file) {
        long fileSize = file.getSize();
        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();

        System.out.println(fileSize);
        System.out.println(fileName);
        System.out.println(contentType);

        try{
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .stream(file.getInputStream(), fileSize, 10485760)
                    .contentType(contentType)
                    .build();
            minioClient.putObject(putObjectArgs);
            return "Upload SUCCESS on bucket: " + bucketName;
        }catch (Exception ex){
            System.out.println(ex);
            return "Upload FAILED :(";
        }
    }

    public String createBucket(String bucketName) {
        try{
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build());
            return "Created bucket with name: " + bucketName;
        }catch (Exception ex){
            System.out.println(ex);
            return "Creation FAILED.. :(";
        }
    }
}
