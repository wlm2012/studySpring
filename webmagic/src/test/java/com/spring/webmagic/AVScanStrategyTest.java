package com.spring.webmagic;

import com.spring.webmagic.repository.AVstarRepository;
import com.spring.webmagic.repository.ResourcesReposity;
import com.spring.webmagic.serviceImp.AVScanStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;


@Import(AVScanStrategy.class)
@ExtendWith(SpringExtension.class)
public class AVScanStrategyTest {

    @MockBean
    private AVstarRepository aVstarRepository;
    @MockBean
    private ResourcesReposity resourcesReposity;

    @Resource
    private AVScanStrategy avScanStrategy;

    @Test
    public void scan() {

    }
}
