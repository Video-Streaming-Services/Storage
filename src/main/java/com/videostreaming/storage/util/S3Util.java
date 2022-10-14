package com.videostreaming.storage.util;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;

public class S3Util {

    private static final String BUCKET = "atypon-video-stream";
    private static final String accessKey = "AKIAURDUIPGQQCX6WW6D";
    private static final String accessSecret = "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";

    public static void uploadFile(String fileName, InputStream inputStream) throws IOException {

        AwsCredentials credentials = AwsBasicCredentials.create(accessKey,accessSecret);
        AwsCredentialsProvider awsCredentialsProvider = StaticCredentialsProvider.create(credentials);
        S3Client s3Client = S3Client.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(awsCredentialsProvider)
                .build();

        PutObjectRequest putObjectRequest = PutObjectRequest
                .builder()
                .bucket(BUCKET)
                .key(fileName)
                .acl("public-read")
                .contentType("video/mp4")
                .build();
        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(inputStream,inputStream.available()));
    }
}
