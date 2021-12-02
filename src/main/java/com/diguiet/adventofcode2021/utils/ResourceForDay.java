package com.diguiet.adventofcode2021.utils;

import com.diguiet.adventofcode2021.day1.Day1;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.nio.charset.Charset;
import java.util.Objects;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public abstract class ResourceForDay {
    @SneakyThrows
    public static String get(int day, String filePath) {
        return IOUtils.toString(
                Objects.requireNonNull(
                        Day1.class.getClassLoader().getResourceAsStream(
                                "com/diguiet/adventofcode2021/day" + day + "/" + filePath
                        )
                ),
                Charset.defaultCharset()
        );
    }

    public static String getInput(int day) {
        return get(day, "input.txt");
    }
}
