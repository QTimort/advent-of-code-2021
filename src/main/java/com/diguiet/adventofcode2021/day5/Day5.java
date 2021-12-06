package com.diguiet.adventofcode2021.day5;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Day5 {
    private static final int DAY = 5;

    @SneakyThrows
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne() {
        final int[][] board = new int[1000][1000];
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        int overlap = 0;
        for (String instruction : instructions) {
            final String[] direction = instruction.split(" -> ");
            final String[] pos1 = direction[0].split(",");
            final String[] pos2 = direction[1].split(",");
            final int x1 = Integer.parseInt(pos1[0]);
            final int y1 = Integer.parseInt(pos1[1]);
            final int x2 = Integer.parseInt(pos2[0]);
            final int y2 = Integer.parseInt(pos2[1]);
            final int minX = Math.min(x1, x2);
            final int maxX = Math.max(x1, x2);
            final int minY = Math.min(y1, y2);
            final int maxY = Math.max(y1, y2);
            if (x1 == x2) {
                for (int y = minY; y <= maxY; ++y) {
                    ++board[y][x1];
                    if (board[y][x1] == 2) {
                        ++overlap;
                    }
                }
            } else if (y1 == y2) {
                for (int x = minX; x <= maxX; ++x) {
                    ++board[y1][x];
                    if (board[y1][x] == 2) {
                        ++overlap;
                    }
                }
            }
        }
        log.info("Result: " + overlap);
    }

    public static void partTwo() {
        final int[][] board = new int[1000][1000];
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        int overlap = 0;
        for (String instruction : instructions) {
            final String[] direction = instruction.split(" -> ");
            final String[] pos1 = direction[0].split(",");
            final String[] pos2 = direction[1].split(",");
            final int x1 = Integer.parseInt(pos1[0]);
            final int y1 = Integer.parseInt(pos1[1]);
            final int x2 = Integer.parseInt(pos2[0]);
            final int y2 = Integer.parseInt(pos2[1]);

            int x = x1;
            int y = y1;
            while (x != x2 || y != y2) {
                ++board[y][x];
                if (board[y][x] == 2) {
                    ++overlap;
                }
                if (x != x2) {
                    x = (x > x2) ? (x - 1) : (x + 1);
                }
                if (y != y2) {
                    y = (y > y2) ? (y - 1) : (y + 1);
                }
            }
            ++board[y][x];
            if (board[y][x] == 2) {
                ++overlap;
            }
        }
        log.info("Result: " + overlap);
    }
}