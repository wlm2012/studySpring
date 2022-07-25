package com.study.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TAddressInfo {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String city;

    private String userInfoId;

    private Long age;
}
