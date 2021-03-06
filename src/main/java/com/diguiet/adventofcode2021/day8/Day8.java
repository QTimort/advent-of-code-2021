package com.diguiet.adventofcode2021.day8;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Day8 {
    private static final int DAY = 8;

    @SneakyThrows
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        log.info("Result: " + 0);
    }

    public static void partTwo() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);

        log.info("Result: " + 0);
    }
}