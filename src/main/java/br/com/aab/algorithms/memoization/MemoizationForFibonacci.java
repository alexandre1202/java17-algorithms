package br.com.aab.algorithms.memoization;

import java.util.HashMap;
import java.util.Map;

public class MemoizationForFibonacci {
    
    private Map<Integer, Long> memo = new HashMap<>();
    
    public long fibonacci(int input) {
        if (input == 0 || input ==1) return input;
        
        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        
        long output = fibonacci(input - 1) + fibonacci(input - 2);
        memo.put(input, output);
        return output;
    }
}
