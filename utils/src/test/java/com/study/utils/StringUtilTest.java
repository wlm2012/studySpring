package com.study.utils;

import com.study.utils.fileUtil.FilesUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class StringUtilTest {

    @Test
    public void test() throws IOException {
        String path = "D:\\error.log";
        String file = FilesUtils.readFile(path);
        for (String s : file.split("错误Qlsxbm")) {
            Arrays.stream(s.split("com.google.gson.JsonSyntaxException"))
                    .filter(ss -> !ss.contains("com"))
                    .forEach(System.out::println);
        }


    }


}
