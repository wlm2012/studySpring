package com.study.utils.controller;

import com.study.utils.VO.NurseDto;
import com.study.utils.concurrency.AsyncServiceImpl;
import com.study.utils.fileUtil.FilesUtils;
import com.study.utils.VO.ImgRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RestTemplateController {

    @Resource
    private RestTemplate okhttpRestTemplate;

    private final AsyncServiceImpl asyncService;

    @RequestMapping("/restTest")
    public void restTest() {
        String forObject = okhttpRestTemplate.getForObject("https://www.baidu.com", String.class);
        log.info(forObject);
    }

    @RequestMapping("/restTest1")
    public String restTest1() throws IOException {
        return FilesUtils.readFile("C:\\Users\\wlm\\Desktop\\new 2.txt");

    }


    @GetMapping("/test")
    @Async
    public void test(String no) throws ExecutionException, InterruptedException {
        NurseDto build = NurseDto.builder()
                .id("1569560342990700546")
                .cardType("0")
                .phoneNo(no)
                .cardNo("410305196711291521").build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl9udXJfdXNlcl9rZXkiOiI1OTJkNWQ1MC05Y2VkLTRkMGItOWNjNi03MTliNGM3ZDVkOTgifQ.UOQA8or8l7okURMwhgkxyCQ9noWUHAARNXN3NlP3rHk6-AHbdmXRkeaHVuwZ0vN4Bwjj4bB4LDrYV4678zvrJA");
        HttpEntity<NurseDto> httpEntity = new HttpEntity<>(build, headers);

        log.info("------begin-------");
        CompletableFuture<ResponseEntity<String>> responseEntityCompletableFuture = asyncService.postForEntity(httpEntity);

        httpEntity = new HttpEntity<>(headers);
        log.info("------begin-------");
        ResponseEntity<String> responseEntity = okhttpRestTemplate.exchange("http://weixin01.lyasyewm.cn:9007/nurse/nurseInfo/1569560342990700546", HttpMethod.GET, httpEntity, String.class);
        log.info("responseEntity.getBody() = " + responseEntity.getBody());

        log.info("stringResponseEntity.getBody() = " + responseEntityCompletableFuture.get().getBody());
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
