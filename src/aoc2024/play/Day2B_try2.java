package aoc2024.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2B_try2 {

    public static boolean checkSafe(List<String> numStr) {
        int currentNum = -1;
        int inc = 0;
        boolean safe = true;
        for (String num : numStr) {
            int number = Integer.parseInt(num);
            if (currentNum == -1) {
                currentNum = number;
                continue;
            }
            if (currentNum > number) {
                if (inc > 0) {
                    safe = false;
                    break;
                } else if (inc == 0) {
                    inc = -1;
                }
                if (Math.abs(currentNum - number) > 3) {
                    safe = false;
                    break;
                }
                currentNum = number;
            } else if (currentNum < number) {
                if (inc < 0) {
                    safe = false;
                    break;
                } else if (inc == 0) {
                    inc = 1;
                }
                if (Math.abs(currentNum - number) > 3) {
                    safe = false;
                    break;
                }
                currentNum = number;
            } else {
                safe = false;
                break;
            }
        }
        return safe;
    }

    public static void main(String[] args) throws IOException  {

        String filePath = "src/aoc2024/input/files/day2a_ip.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int ii = 0;
            int num_safe = 0;
            while ((line = br.readLine()) != null && ii < 1000) {
                String[] numStr = line.split(" ");

                List<String> numList = new ArrayList<>();
                numList.addAll(Arrays.stream(numStr).toList());
                boolean safe = checkSafe(numList);
                if (!safe) {
                    for (int i = 0; i < numStr.length; i++) {
                        numList = new ArrayList<>();
                        numList.addAll(Arrays.stream(numStr).toList());
                        numList.remove(i);
                        safe = checkSafe(numList);
                        if (safe) break;
                    }
                    if (!safe) System.out.println(line);
                }
                num_safe += safe ? 1 : 0;
            }
            System.out.println("num_safe: " + num_safe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}