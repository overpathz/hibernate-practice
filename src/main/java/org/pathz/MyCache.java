package org.pathz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyCache {
    private final Map<String, Integer> cache = new HashMap<>();

    public int calculate(String equation) {
        if (cache.get(equation) != null) {
            return cache.get(equation);
        }
        String[] split = equation.split("\\+");
        System.out.println(Arrays.toString(split));
        int first = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[1]);
        int result = first + second;
        cache.put(equation, result);
        return result;
    }

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        int calculate1 = myCache.calculate("1+1");
        int calculate2 = myCache.calculate("1+1");
        System.out.println(calculate1);
        System.out.println(calculate2);
    }
}
