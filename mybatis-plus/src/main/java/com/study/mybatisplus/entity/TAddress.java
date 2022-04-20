package com.study.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
}
