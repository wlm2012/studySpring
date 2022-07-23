package com.study.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Data;
import org.springframework.boot.configurationprocessor.json.JSONArray;

@Data
@TableName(value = "t_json", autoResultMap = true)
public class TJson {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer orderId;

//    @TableField(typeHandler = JacksonTypeHandler.class)
//    @JsonFormat
    private String content;
}
