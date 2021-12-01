package com.diguiet.adventofcode2021.day1;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.nio.charset.Charset;
import java.util.Objects;

@Slf4j
public class Day1 {
    @SneakyThrows
    public static void main(String[] args) {
        final String input = IOUtils.toString(
                Objects.requireNonNull(Day1.class.getClassLoader().getResourceAsStream("com/diguiet/adventofcode2021/day1/input.txt")),
                Charset.defaultCharset()
        );
        log.info(input);
    }

}