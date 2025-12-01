package aoc2024.play;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {

    public static void main(String[] args) {
        String input = "src/aoc2024/input/files/day5_ip.txt";
        try (BufferedReader bf = new BufferedReader(new FileReader(input))) {
            int iLine = 0, correctlyOrderedUpdates = 0, correctlyOrderedUpdatesAfterReArrange = 0;
            List<String> ruleList = new ArrayList<>();
            while (iLine < 1385) {
                String line = bf.readLine();

                if (line == null) {
                    continue;
                }

                if (line.contains("|")) {
                    ruleList.add(line);
                }

                if (line.contains (",")) {
                    boolean isCorrectlyOrdered = true;
                    String[] strArrIP = line.split(",");
                    isCorrectlyOrdered = isCorrectlyOrdered(strArrIP, ruleList, isCorrectlyOrdered);

                    if (isCorrectlyOrdered) {
                        correctlyOrderedUpdates += Integer.parseInt(strArrIP[strArrIP.length / 2]);
                    }

                    if (!isCorrectlyOrdered) {
                        String[] strArrIpReArranged = isCorrectlyOrderedAfterReArrange(strArrIP, ruleList);

                        if (isCorrectlyOrdered(strArrIpReArranged, ruleList, !isCorrectlyOrdered)){
                            correctlyOrderedUpdatesAfterReArrange += Integer.parseInt(strArrIpReArranged[strArrIP.length / 2]);
                        }
                    }
                }
                iLine++;
            }
            System.out.println("correctlyOrderedUpdates: " + correctlyOrderedUpdates);
            System.out.println("correctlyOrderedUpdatesAfterReArrange: " + correctlyOrderedUpdatesAfterReArrange);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isCorrectlyOrdered(String[] strArrIP, List<String> ruleList, boolean correctlyOrdered) {
        for (int i = 0; i < strArrIP.length - 1; i++) {
            for (int j = i + 1; j < strArrIP.length; j++) {
                if (!(ruleList.contains(strArrIP[i] + "|" + strArrIP[j]))) {
                    correctlyOrdered = false;
                    break;
                }
            }
        }
        return correctlyOrdered;
    }

    private static String[] isCorrectlyOrderedAfterReArrange(String[] strArrIP, List<String> ruleList) {
        String[] strArrIpReArranged = Arrays.copyOfRange(strArrIP, 0, strArrIP.length);
        for (int i = 0; i < strArrIP.length - 1; i++) {
            for (int j = i + 1; j < strArrIP.length; j++) {
                if (!(ruleList.contains(strArrIpReArranged[i] + "|" + strArrIpReArranged[j]))) {
                    strArrIpReArranged[i] = strArrIP[j];
                    strArrIpReArranged[j] = strArrIP[i];

                    strArrIP = Arrays.copyOfRange(strArrIpReArranged, 0, strArrIpReArranged.length);
                }
            }
        }
        return strArrIpReArranged;
    }

}