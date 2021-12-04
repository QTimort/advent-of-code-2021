package com.diguiet.adventofcode2021.day3;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Day3 {
    private static final int DAY = 3;

    @SneakyThrows
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        final int nbBits = instructions.get(0).length();
        final int[] bitAtZero = new int[nbBits];
        final int majority = instructions.size() / 2;
        for (String instruction : instructions) {
            for (int i = 0; i < nbBits; i++) {
                if (instruction.charAt(i) == '0') {
                    ++bitAtZero[i];
                }
            }
        }
        String gamma = "";
        for (int i = 0; i < nbBits; i++) {
            gamma = gamma.concat((bitAtZero[i] > majority) ? "1" : "0");
        }
        // flip gamma bits
        final String epsilon = gamma.chars().mapToObj(c -> ((c == '1') ? "0" : "1")).collect(Collectors.joining());
        log.info("Result: " + Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
    }

    public static void partTwo() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        final int oxygen = getRating(instructions, true);
        final int co2 = getRating(instructions, false);

        log.info("Result: " + oxygen * co2);
    }

    private static int getRating(final List<String> instructions, boolean isBasedOnMostCommonValue) {
        List<String> ratingFiltered = new ArrayList<>(instructions);
        int bitPos = 0;
        while (ratingFiltered.size() > 1) {
            final int finalBitPos = bitPos++;
            int bitsSetToOne = (int) ratingFiltered
                    .stream()
                    .filter(s -> s.charAt(finalBitPos) == '1')
                    .count();
            final boolean isOneMostCommon = bitsSetToOne * 2 >= ratingFiltered.size();
            ratingFiltered = ratingFiltered
                    .stream()
                    .filter((s) -> s.charAt(finalBitPos) == ((isOneMostCommon == isBasedOnMostCommonValue) ? '1' : '0'))
                    .collect(Collectors.toList());
        }
        return Integer.parseInt(ratingFiltered.get(0), 2);
    }
}