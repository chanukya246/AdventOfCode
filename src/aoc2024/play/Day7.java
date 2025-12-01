package aoc2024.play;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Day7 {
    static Map<Long, List<Long>> parseInput(String filename) throws IOException {
        Map<Long, List<Long>> res = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            for (String line; (line = reader.readLine()) != null;) {
                String[] parts = line.split(": ");
                Long value = Long.parseLong(parts[0]);
                List<Long> equations = Stream.of(parts[1].split(" ")).map(Long::parseLong)
                        .collect(Collectors.toList());
                assert (!res.containsKey(value));
                res.put(value, equations);
            }
        }
        return res;
    }

    static boolean canProduceTestValue(List<Long> equation, Long value) {
        List<BiFunction<Long, Long, Long>> opList = List.of(
                (a, b) -> a + b,
                (a, b) -> a * b);
        return dfs(equation, 1, equation.get(0), value, opList);
    }

    static boolean dfs(List<Long> equation, int i, Long cur, Long target, List<BiFunction<Long, Long, Long>> opList) {
        if (i == equation.size()) {
            return cur.equals(target);
        }

        return opList.stream().anyMatch(fn -> dfs(equation, i + 1, fn.apply(cur, equation.get(i)), target, opList));
    }

    static final BiFunction<Long, Long, Long> CONCAT_FN = (a,
                                                           b) -> a * (long) Math.pow(10, countDigits(b))
            + b;

    static boolean canProduceTestValueV2(List<Long> equation, Long value) {
        List<BiFunction<Long, Long, Long>> opList = List.of(
                (a, b) -> a + b,
                (a, b) -> a * b,
                CONCAT_FN);
        return dfs(equation, 1, equation.get(0), value, opList);
    }

    public static void main(String[] args) throws IOException {
        Map<Long, List<Long>> equations = parseInput("src/aoc2024/input/files/day7_ip.txt");
        Long totalCalibrationResult = equations.entrySet().stream()
                .filter(e -> canProduceTestValue(e.getValue(), e.getKey()))
                .mapToLong(e -> e.getKey()).sum();

        Long totalCalibrationResultV2 = equations.entrySet().stream()
                .filter(e -> canProduceTestValueV2(e.getValue(), e.getKey()))
                .mapToLong(e -> e.getKey()).sum();

        System.out.println("part1: " + totalCalibrationResult);
        System.out.println("part2: " + totalCalibrationResultV2);
    }

    public static <T extends Number> long countDigits(T number) {
        long n = number.longValue();
        return n == 0 ? 1 : (long) Math.log10(Math.abs(n)) + 1;
    }

}