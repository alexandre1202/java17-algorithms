package br.com.aab.hackerrank.jobsity;

import java.util.Arrays;
import java.util.List;

public class DiskSpaceAnalisys {
    public static void main(String[] args) {
        System.out.println("2, 5, 4, 6, 8 and window 3 should be 4 => " + segment(3, Arrays.asList(2, 5, 4, 6, 8)));

//        System.out.println("2, 5, 4, 6, 8 and window 3 should be 4 => " + getMax(new int[]{2, 5, 4, 6, 8}, 3));
//        System.out.println("1, 2, 3, 1, 2 and window 1 should be 3 => " + getMax(new int[]{1, 2, 3, 1, 2}, 1));
//        System.out.println("8,2,4,6 and window 2 should be 4 => " + getMax(new int[]{8,2,4,6}, 2));
//        System.out.println("9, 7, 7, 9, 1, 2, 4, 8, 3 and window 3 should be 7 => " + getMax(new int[]{9, 7, 7, 9, 1, 2, 4, 8, 3}, 3));
    }


    public static int segment(int x, List<Integer> space) {
        int result = 0, minimum = space.get(0), segmentCount = 0, limit = space.size();
        for (int i = 0; i < limit; i++) {
            int element = space.get(i);
            minimum = minimum < element ? minimum : space.get(i);
            if (segmentCount < x) {
                segmentCount++;
            } else {
                result = minimum > result ? minimum : result;
                segmentCount = 0;
            }
        }
        return result;
    }

// @BrunoTaboada
//    private static Integer getMax(int[] input, int window){
//        var c = 0;
//        var p = 1;
//        var p1 = Integer.MAX_VALUE;
//        var p2 = Integer.MIN_VALUE;
//        while (c < input.length) {
//            var val = input[c++];
//            if(val < p1){
//                p1 = val;
//            }
//            if(p == window){
//                if(p1 > p2){
//                    p2 = p1;
//                }
//                if (window > 1) {
//                    p=1;
//                    p1 = Integer.MAX_VALUE;
//                    if (window != 1) c--;
//                    continue;
//                }
//            }
//            p++;
//        }
//
//        return p2;
//    }

// @BrunoTaboada - Latest version
//    private static Integer getMax(int[] input, int window){
//        var c = 0;
//        var p = 1;
//        var p1 = Integer.MAX_VALUE;
//        var p2 = Integer.MIN_VALUE;
//        while (c < input.length) {
//            var val = input[c++];
//            if(val < p1){
//                p1 = val;
//            }
//            if(p == window){
//                if(p1 > p2){
//                    p2 = p1;
//                }
//                if(window != 1)c--;
//                p1 = Integer.MAX_VALUE;
//                p=1;
//                continue;
//            }
//            p++;
//        }
//        return p2;
//    }
}
