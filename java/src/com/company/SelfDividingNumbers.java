package com.company;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        List<Integer> integers = selfDividingNumbers(1, 22);
        System.out.println("tests passed");

    }

    // Time O(n ^2) and Space O(n)
    public static List<Integer> selfDividingNumbers(int left, int right) {
        var list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            int number = i;
            while (true) {
                int digit = number % 10;
                if (digit == 0) break;
                if (i % digit == 0) {
                    number = number / 10;
                } else break;

                if (number == 0) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
