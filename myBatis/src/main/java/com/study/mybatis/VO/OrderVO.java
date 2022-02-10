package com.study.mybatis.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderVO {

    @NotBlank
    private String name;

    @Min(0)
    private int num;

    @DecimalMin("0")
    private BigDecimal price;

    @Future
    // 对json 格式无效
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @JsonFormat 对参数传入 返回的格式转换都生效
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime orderTime;
}
