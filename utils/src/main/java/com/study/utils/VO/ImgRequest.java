package com.study.utils.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImgRequest {
    private String url;
    private String lsh;
    private String fjmc;
    private String xh;
    private String ckyt;
}
