package aoc2024.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day1B {

    public static void main(String[] args) {
        String filePath = "src/aoc2024/input/files/day1b_ip.txt"; // Replace with your file path
        int[] al1 = new int[1000];
        Map<Integer, Integer> map2 = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < 1000) {
                String[] temp = line.split("   ");
                al1[i] = Integer.parseInt(temp[0]);
                if (map2.containsKey(Integer.parseInt(temp[1]))) {
                    map2.put(Integer.parseInt(temp[1]), map2.get(Integer.parseInt(temp[1])) + 1);
                } else {
                    map2.put(Integer.parseInt(temp[1]), 1);
                }
                i++;
            }
            int result = 0;
            for (int k = 0; k < 1000; k++){
                if (null != map2.get(al1[k]))
                result += al1[k] * map2.get(al1[k]);
            }
            System.out.println("result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
