package com.diguiet.adventofcode2021.utils;

import com.diguiet.adventofcode2021.day1.Day1;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static Stream<String> getInputAsStream(int day) {
        return Arrays
                .stream(ResourceForDay.getInput(day).split(System.lineSeparator()));
    }

    public static List<String> getInputAsList(int day) {
        return getInputAsStream(day).collect(Collectors.toList());
    }

    public static List<Integer> getInputAsListOfInt(int day) {
        return getInputAsStream(day).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<Double> getInputAsListOfDouble(int day) {
        return getInputAsStream(day).map(Double::parseDouble).collect(Collectors.toList());
    }
}
