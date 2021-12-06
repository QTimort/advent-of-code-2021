package com.diguiet.adventofcode2021.day6;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Day6 {
    private static final int DAY = 6;

    @SneakyThrows
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    // naive approach
    public static void partOne() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        final String lanternsStr = instructions.get(0);
        final List<Integer> lanterns = Arrays.stream(lanternsStr.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        for (int day = 0; day < 80; ++day) {
            final int size = lanterns.size();
            for (int i = 0; i < size; i++) {
                final int lanternValue = lanterns.get(i);
                if (lanternValue == 0) {
                    lanterns.set(i, 6);
                    lanterns.add(lanterns.size(), 8);
                } else {
                    lanterns.set(i, lanternValue - 1);
                }
            }
        }
        log.info("Result: " + lanterns.size());
    }

    // optimized approach
    public static void partTwo() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        final String lanternsStr = instructions.get(0);
        final long[] lanternsDigitMap = new long[9];
        final List<Integer> lanterns = Arrays.stream(lanternsStr.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        for (final int lanternDigitMapValue : lanterns) {
            ++lanternsDigitMap[lanternDigitMapValue];
        }
        for (int day = 0; day < 256 ; ++day) {
            long prevZero = lanternsDigitMap[0];
            // left shift
            System.arraycopy(lanternsDigitMap, 1, lanternsDigitMap, 0, 8);
            // set new lanterns
            lanternsDigitMap[8] = prevZero;
            // reset lanterns
            lanternsDigitMap[6] += prevZero;
        }
        final long sum = Arrays.stream(lanternsDigitMap).sum();
        log.info("Result: " + sum);
    }
}