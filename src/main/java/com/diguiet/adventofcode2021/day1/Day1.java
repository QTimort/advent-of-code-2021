package com.diguiet.adventofcode2021.day1;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Day1 {
    @SneakyThrows
    public static void main(String[] args) {
        partOne();
    }

    public static void partOne() {
        final String input = ResourceForDay.getInput(1);
        final List<Integer> measures = Arrays
                .stream(input.split(System.lineSeparator()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int prevMeasure = 0;
        for (int i = 0; i < measures.size(); i++) {
            if (i > 0 && measures.get(i - 1) < measures.get(i)) {
                ++prevMeasure;
            }
        }
        log.info("number of time the measures increased: " + prevMeasure);
    }
}