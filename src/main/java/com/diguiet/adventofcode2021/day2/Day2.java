package com.diguiet.adventofcode2021.day2;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Day2 {
    @SneakyThrows
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne() {
        final List<String> instructions = ResourceForDay.getInputAsList(2);
        int hori = 0;
        int depth = 0;
        for (final String instruction : instructions) {
            final String[] parameters = instruction.split(" ");
            final int dist = Integer.parseInt(parameters[1]);
            if (parameters[0].equals("forward")) {
                hori += dist;
            }
            if (parameters[0].equals("down")) {
                depth += dist;
            }
            if (parameters[0].equals("up")) {
                depth -= dist;
            }
        }
        log.info("Result: " + hori * depth);
    }

    public static void partTwo() {
        final List<String> instructions = ResourceForDay.getInputAsList(2);
        int hori = 0;
        int depth = 0;
        int aim = 0;
        for (final String instruction : instructions) {
            final String[] parameters = instruction.split(" ");
            int dist = Integer.parseInt(parameters[1]);
            if (parameters[0].equals("forward")) {
                hori += dist;
                depth += aim * dist;
            }
            if (parameters[0].equals("down")) {
                aim += dist;
            }
            if (parameters[0].equals("up")) {
                aim -= dist;
            }
        }
        log.info("Result: " + hori * depth);
    }
}