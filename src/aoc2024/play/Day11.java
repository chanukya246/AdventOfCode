package aoc2024.play;

import java.math.BigInteger;

public class Day11 {

    static int TWENTY_FIVE_BLINKS = 25;
    static int SEVENTY_FIVE_BLINKS = 75;

    public static void main(String[] args) {
        String input = "17639 47 3858 0 470624 9467423 5 188";
        day11part1(input, TWENTY_FIVE_BLINKS);
    }

    private static void day11part1(String input, int blink) {
        StringBuilder sb = new StringBuilder();
        String[] ipSplit = input.split(" ");
        while (blink > 0) {
            for (String str : ipSplit) {
                int strLength = str.trim().toCharArray().length;
                BigInteger bi = new BigInteger(str.trim());
                if (bi.compareTo(BigInteger.ZERO) == 0) {
                    sb.append("1").append(" ");
                } else if (strLength % 2 == 0) {
                    sb.append(new BigInteger(str.substring(0, strLength / 2))).append(" ");
                    sb.append(new BigInteger(str.substring(strLength / 2))).append(" ");
                } else {
                    sb.append(bi.multiply(BigInteger.valueOf(2024))).append(" ");
                }
            }
            ipSplit = sb.toString().split(" ");
            blink--;
            System.out.println("sb length is : " + ipSplit.length + ", after : " + (TWENTY_FIVE_BLINKS - blink) + " blinks");
            sb.setLength(0);
        }

    }
}
