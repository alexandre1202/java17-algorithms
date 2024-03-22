package br.com.aab.codechallenge.hackerrank.easy;

public class NumberLineJumps {
    public String kangaroo(int x1, int v1, int x2, int v2) {
        return ((v1 > v2) && ((x2 - x1) % (v1 - v2) == 0)) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        NumberLineJumps numberLineJumps = new NumberLineJumps();
        int x1 = 0;
        int v1 = 3;
        int x2 = 4;
        int v2 = 2;
        var result = numberLineJumps.kangaroo(x1, v1, x2, v2);
        System.out.printf("1 (Answer must be [YES]) - Kangaroo 1 =>  x1 = [%d], v1 = [%d] and Kangaroo 2 => x2 = [%d], v2 = [%d], so the result is [%s]%n",
                x1, v1, x2, v2, result);

        x1 = 0;
        v1 = 2;
        x2 = 5;
        v2 = 3;
        result = numberLineJumps.kangaroo(x1, v1, x2, v2);
        System.out.printf("2 (Answer must be [NO]) - Kangaroo 1 =>  x1 = [%d], v1 = [%d] and Kangaroo 2 => x2 = [%d], v2 = [%d], so the result is [%s]%n",
                x1, v1, x2, v2, result);
        
    }
}
