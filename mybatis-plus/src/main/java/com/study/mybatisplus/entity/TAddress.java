package com.study.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@TableName("t_address")
@AllArgsConstructor
@NoArgsConstructor
public class TAddress {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String city;

    private String userInfoId;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;
}
