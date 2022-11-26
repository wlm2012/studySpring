package com.study.utils.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class TesseractTest {

    public static String test(String path) throws TesseractException {
        File image = new File(path);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/java/com/study/utils/ocr");
        tesseract.setLanguage("chi_sim");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        return tesseract.doOCR(image);
    }


}
