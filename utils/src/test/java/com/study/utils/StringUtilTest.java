package com.study.utils;

import com.study.utils.fileUtil.FilesUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

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

    @Test
    void reduce() {
        String[] split = "com.google.gson.JsonSyntaxException".split("\\.");
        if (split.length > 0) {
            Optional<String> reduce1 = Arrays.stream(split).reduce((t, s) -> t + "," + s);
            String reduce = reduce1.get();
            System.out.println("reduce = " + reduce);
        }


    }


}
