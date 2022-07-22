package com.study.mybatisplus.controller;

import com.study.mybatisplus.domain.entity.TJson;
import com.study.mybatisplus.mapper.TJsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JsonController {

    private final TJsonMapper jsonMapper;

    @RequestMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody TJson json) {
        System.out.println("json = " + json);

        String content = "{\n" +
                "        \"msg\": \"操作成功\",\n" +
                "        \"code\": 200,\n" +
                "        \"token\": \"eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl9udXJfdXNlcl9rZXkiOiIyYTUxN2FiZC1lMzAzLTQzNzUtODM5OC1hMTZhZWI5YzMzNzYifQ.Jp71Uru5kI1IGJv3soUje4vYB0SIltEuWdfhECO8QUueP_28pA9mAv88G-J46v50e2fJCRrRMkZ-Ox6pCSFJ4g\"\n" +
                "    }";
        json.setContent(content);
        jsonMapper.insert(json);
        return content;
    }
}
