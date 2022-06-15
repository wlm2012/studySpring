package com.study.mybatisplus.controller;

import com.study.utils.fileUtil.FilesUtils;
import okhttp3.internal.io.FileSystem;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String url = "./upload".replace("/", File.separator)
                .replace("\\", File.separator);
        url = url + File.separator + file.getOriginalFilename();
        FilesUtils.createFile(url, file.getBytes());
        return url;
    }

    @GetMapping(value = "/download")
    private ResponseEntity<byte[]> download(String path) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        // 指定以流的形式下载文件
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        MediaType mediaType = MediaTypeFactory.getMediaType(path.substring(path.lastIndexOf(File.separator))).get();
        headers.setContentType(mediaType);
        return new ResponseEntity<>(FilesUtils.readFileToByte(path), headers, HttpStatus.OK);

    }
}
