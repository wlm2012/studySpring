package com.study.utils.ocr;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TesseractTestTest {

    @Test
    void chiOcr() throws TesseractException {
        log.info(TesseractTest.test("src/main/java/com/study/utils/ocr/Snipaste_2022-11-26_08-51-40.png"));
    }

}