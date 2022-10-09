package com.study.utils.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NurseDto {

    private String id;

    private String cardType;

    private String cardNo;

    private String phoneNo;

    private String avatar;
}
