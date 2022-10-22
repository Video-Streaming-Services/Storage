package com.videostreaming.storage.controller;

import com.videostreaming.storage.util.S3Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private final S3Util s3Util;

    public FileController(S3Util s3Util) {
        this.s3Util = s3Util;
    }

    @PostMapping("/")
    public String uploadToS3(@RequestBody MultipartFile file, @RequestParam("name") String name) {
        try {
            s3Util.uploadFile(name, file.getInputStream());
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }
}
