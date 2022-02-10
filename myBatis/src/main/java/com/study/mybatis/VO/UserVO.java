package com.study.mybatis.VO;

import com.study.mybatis.validation.IsAdult;
import com.study.mybatis.validation.Update;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class UserVO {

    @NotBlank(message = "用户名不能为空", groups = Update.class)
    private String name;

    private String mobile;

    @IsAdult
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Valid
    private OrderVO orderVO;
}
