package com.parley.parley.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class S3Client {
    private AmazonS3 s3client;

    @Value("${amazon.aws.accesskey}")
    private String accessKey;

    @Value("${amazon.aws.secretkey}")
    private String secretKey;

    @Value("${amazon.s3.endpoint.prompt}")
    private String prompt_endpointUrl;

    @Value("${amazon.aws.bucket.prompt}")
    private String prompt_bucket;

    @Value("${amazon.s3.endpoint.wb}")
    private String wb_endpointUrl;

    @Value("${amazon.aws.bucket.wb}")
    private String wb_bucket;

    @Value("${amazon.s3.endpoint.pdf}")
    private String pdf_endpointUrl;

    @Value("${amazon.aws.bucket.pdf}")
    private String pdf_bucket;

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3client = new AmazonS3Client(credentials);
    }

    public String uploadFile2Prompts(MultipartFile multipartFile) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = prompt_endpointUrl + "/" + fileName;
            uploadFileTos3bucket(fileName, file, prompt_bucket);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

    public String uploadFile2Wbs(MultipartFile multipartFile) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = wb_endpointUrl + "/" + fileName;
            uploadFileTos3bucket(fileName, file, wb_bucket);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

    public String uploadFile2Pdfs(MultipartFile multipartFile) {
        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = pdf_endpointUrl + "/" + fileName;
            uploadFileTos3bucket(fileName, file, pdf_bucket);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file, String bucket) {
        s3client.putObject(new PutObjectRequest(bucket, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String deleteFileFromPrompts(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(prompt_bucket, fileName));
        return "Successfully deleted";
    }

    public String deleteFileFromWbs(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(wb_bucket, fileName));
        return "Successfully deleted";
    }

    public String deleteFileFromPdfs(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(pdf_bucket, fileName));
        return "Successfully deleted";
    }
}
