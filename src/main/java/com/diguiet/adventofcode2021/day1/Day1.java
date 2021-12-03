package com.diguiet.adventofcode2021.day1;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Day1 {
    private static final int DAY = 1;

    @SneakyThrows
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne() {
        final List<Integer> measures = ResourceForDay.getInputAsListOfInt(DAY);
        int timeIncreased = 0;
        for (int i = 0; i < measures.size(); i++) {
            if (i > 0 && measures.get(i - 1) < measures.get(i)) {
                ++timeIncreased;
            }
        }
        log.info("Part 1: Number of time the measures increased: " + timeIncreased);
    }

    public static void partTwo() {
        final List<Integer> measures = ResourceForDay.getInputAsListOfInt(DAY);
        int timeIncreased = 0;
        int rollingWindow = 0;

        for (int i = 0; i < measures.size(); ++i) {
            final int nextMeasure = measures.get(i);
            final int nextWindow;

            if (i > 2) {
                // remove the value that went out of the window, and add the one that entered.
                nextWindow = rollingWindow - measures.get(i - 3) + nextMeasure;
                if (rollingWindow < nextWindow) {
                    ++timeIncreased;
                }
            } else {
                nextWindow = rollingWindow + nextMeasure;
            }
            rollingWindow = nextWindow;
        }
        log.info("Part 2: Number of time the measures increased: " + timeIncreased);
    }
}