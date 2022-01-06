package com.study.utils.controller;

import com.study.utils.fileUtil.FilesUtils;
import com.study.utils.VO.ImgRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController
public class RestTemplateController {

    @Resource
    private RestTemplate okhttpRestTemplate;

    @RequestMapping("/restTest")
    public void restTest() {
        String forObject = okhttpRestTemplate.getForObject("https://www.baidu.com", String.class);
        log.info(forObject);
    }

    @RequestMapping("/restTest1")
    public String restTest1() throws IOException {
        return FilesUtils.readFile("C:\\Users\\wlm\\Desktop\\new 2.txt");

    }

/*    @RequestMapping("/rest")
    public void rest() {
        String url = "http://10.68.10.6:8090/api/get_img";
        url = "http://127.0.0.1:8016/get_img";
        ImgRequest imgRequest = ImgRequest.builder().ckyt("yes").fjmc("公共租赁住房租赁合同")
                .lsh("000733921d6f44ddb48c6c4f584a4e51")
                .url("http://recept.zjzwfw.gov.cn/media/oss/DEFAULT/FORM/MATERIAL/427788a0-fd90-3778-aa72-7b19e6951ca9.jpg")
                .xh("1")
                .build();
        ResponseEntity<String> response = okhttpRestTemplate.postForEntity(url, imgRequest, String.class);
        FilesUtils.createFile("./1.jpg", response.getBody().getBytes());


        imgRequest = ImgRequest.builder().ckyt("yes").fjmc("公租房租金缴纳凭证")
                .lsh("000733921d6f44ddb48c6c4f584a4e51")
                .url("http://recept.zjzwfw.gov.cn/media/oss/DEFAULT/FORM/MATERIAL/cd0fcca4-d769-39e9-a430-9b1a5b9208ea.png")
                .xh("1")
                .build();
        response = okhttpRestTemplate.postForEntity(url, imgRequest, String.class);
        FilesUtils.createFile("./2.jpg", response.getBody().getBytes());
    }*/

    @RequestMapping("/get_img")
    public String getImg(@RequestBody ImgRequest imgRequest) {
        String url = "http://10.68.10.6:8090/api/get_img";
        ResponseEntity<String> response = okhttpRestTemplate.postForEntity(url, imgRequest, String.class);
        return response.getBody();
    }


}
