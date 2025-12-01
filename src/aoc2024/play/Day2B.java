package aoc2024.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2B {

    public static void main(String[] args) {
        String filePath = "src/aoc2024/input/files/day2b_ip.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            int safeReports = 0;
            while ((line = br.readLine()) != null && i < 1000) {
                String[] str = line.split(" ");
                boolean ascending = false;
                boolean descending = false;
                if (str.length > 1 && (Integer.parseInt(str[0]) > Integer.parseInt(str[1]))
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) > 0
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) < 4) {
                    descending = true;
                } else if (str.length > 1 && (Integer.parseInt(str[0]) < Integer.parseInt(str[1]))
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) > 0
                        && Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[1])) < 4) {
                    ascending = true;
                }

                if (ascending) {
                    ascending = checkIfAscendingSafe(str, ascending);
                    if (!ascending) {
                        ascending = checkSafeByRemoval(str, ascending, "ascending");
                    }
                } else if (descending) {
                    descending = checkIfDescendingSafe(str, descending);
                    if (!descending) {
                        descending = checkSafeByRemoval(str, descending, "descending");
                    }
                }
                i++;
                if (ascending || descending) {
                    safeReports++;
                }
            }
            System.out.println("safeReports: " + safeReports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIfDescendingSafe(String[] str, boolean descending) {
        for (int j = 1; j < str.length; j++) {
            int prev = Integer.parseInt(str[j - 1]);
            int curr = Integer.parseInt(str[j]);
            int abs = Math.abs(curr - prev);
            if (!((prev > curr) && abs > 0 && abs < 4)) {
                descending = false;
                break;
            }
        }
        return descending;
    }

    private static boolean checkIfAscendingSafe(String[] str, boolean ascending) {
        for (int j = 1; j < str.length; j++) {
            int prev = Integer.parseInt(str[j - 1]);
            int curr = Integer.parseInt(str[j]);
            int abs = Math.abs(curr - prev);
            if (!((prev < curr) && abs > 0 && abs < 4)) {
                ascending = false;
                break;
            }
        }
        return ascending;
    }

    private static boolean checkSafeByRemoval(String[] str, boolean ascOrDescSafeFlag, String ascOrDesc) {
        for (int i = 0; i < str.length; i++) {
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.stream(str).toList());
            list.remove(i);
            if (ascOrDesc.equalsIgnoreCase("ascending")) {
                ascOrDescSafeFlag = checkIfAscendingSafe(list.toArray(new String[0]), !ascOrDescSafeFlag);
            } else if (ascOrDesc.equalsIgnoreCase("descending")) {
                ascOrDescSafeFlag = checkIfDescendingSafe(list.toArray(new String[0]), !ascOrDescSafeFlag);
            }
            if (ascOrDescSafeFlag) {
                break;
            }
        }
        return ascOrDescSafeFlag;
    }

}
