package com.study.mybatis.VO;

import lombok.Data;

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
    private LocalDateTime orderTime;
}
