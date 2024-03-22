package br.com.aab.codechallenge.hackerrank.easy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem?isFullScreen=true
 */
public class TimeConversion {
    public static String timeConversion(String s) {
        if (Objects.isNull(s) || s.trim().length() < 10) return "";
        boolean posMeridian = "PM".equals(s.substring(8,10));
        String[] split = s.substring(0,8).split(":");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        int hour = Integer.parseInt(split[0]);
        int hour24Hour = hour % 12 + (posMeridian ? 12 :  0);
        LocalTime lt = LocalTime.of(hour24Hour, Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        return lt.format(formatter);
    }

    public static void main(String[] args) {
        String input1 = "07:05:45PM";
        String result1 = timeConversion(input1);
        System.out.printf("result %s%n", result1);
    }
}
