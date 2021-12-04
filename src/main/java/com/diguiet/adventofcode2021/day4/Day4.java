package com.diguiet.adventofcode2021.day4;

import com.diguiet.adventofcode2021.utils.ResourceForDay;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class Day4 {
    private static final int DAY = 4;

    @SneakyThrows
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        int[] randomNumbers = Arrays.stream(instructions.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        int[][][] boards = new int[100][5][5];
        for (int i = 0; i < 100; ++i) {
            for (int y = 1; y < 6; ++y) {
                final String s = instructions.get(1 + i * 6 + y);
                int[] n = Arrays.stream(s.split(" ")).filter(t -> !t.isEmpty()).mapToInt(Integer::parseInt).toArray();
                System.arraycopy(n, 0, boards[i][y - 1], 0, 5);
                log.info(s);
            }
        }
        for (int randomNumber : randomNumbers) {
            for (int i = 0; i < 100; ++i) {
                for (int y = 0; y < 5; ++y) {
                    for (int x = 0; x < 5; ++x) {
                        if (boards[i][y][x] == randomNumber) {
                            boards[i][y][x] = -1;
                            for (int j = 0; j < 5; ++j) {
                                if (boards[i][y][j] != -1) {
                                    break;
                                }
                                if (j == 4) {
                                    log.info("bingo: " + boardSum(boards[i]) * randomNumber);
                                    return;
                                }
                            }
                            for (int j = 0; j < 5; ++j) {
                                if (boards[i][j][x] != -1) {
                                    break;
                                }
                                if (j == 4) {
                                    log.info("bingo: " + boardSum(boards[i]) * randomNumber);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static int boardSum(int[][] boards) {
        int sum = 0;
        for (int y = 0; y < 5; ++y) {
            for (int x = 0; x < 5; ++x) {
                if (boards[y][x] != -1) {
                    sum += boards[y][x];
                }
            }
        }
        return sum;
    }

    public static void partTwo() {
        final List<String> instructions = ResourceForDay.getInputAsList(DAY);
        int[] randomNumbers = Arrays.stream(instructions.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        int[][][] boards = new int[100][5][5];
        for (int i = 0; i < 100; ++i) {
            for (int y = 1; y < 6; ++y) {
                final String s = instructions.get(1 + i * 6 + y);
                int[] n = Arrays.stream(s.split(" ")).filter(t -> !t.isEmpty()).mapToInt(Integer::parseInt).toArray();
                System.arraycopy(n, 0, boards[i][y - 1], 0, 5);
                log.info(s);
            }
        }
        Set<Integer> winners = new HashSet<>();
        int lastWinScore = -1;
        for (int randomNumber : randomNumbers) {
            for (int i = 0; i < 100; ++i) {
                if (winners.contains(i)) {
                    continue;
                }
                for (int y = 0; y < 5; ++y) {
                    for (int x = 0; x < 5; ++x) {
                        if (boards[i][y][x] == randomNumber) {
                            boards[i][y][x] = -1;
                            for (int j = 0; j < 5; ++j) {
                                if (boards[i][y][j] != -1) {
                                    break;
                                }
                                if (j == 4) {
                                    winners.add(i);
                                    lastWinScore = boardSum(boards[i]) * randomNumber;
                                }
                            }
                            for (int j = 0; j < 5; ++j) {
                                if (boards[i][j][x] != -1) {
                                    break;
                                }
                                if (j == 4) {
                                    winners.add(i);
                                    lastWinScore = boardSum(boards[i]) * randomNumber;
                                }
                            }
                        }
                    }
                }
            }
        }
        log.info("Result: " + lastWinScore);
    }
}