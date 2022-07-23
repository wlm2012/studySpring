package com.study.mybatisplus.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TAddressInfo {

    private Long id;

    private String city;

    private String userInfoId;

    private Long age;
}
