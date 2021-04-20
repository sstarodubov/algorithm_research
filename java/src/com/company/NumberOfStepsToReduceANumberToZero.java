package com.company;

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {

        assert 6 == numberOfSteps(14) : "6";
        assert 4 == numberOfSteps(8) : "4";
        assert 12 == numberOfSteps(123) : "12";
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(1)
    public static int numberOfSteps(int num) {
        int out = 0;
        while (num != 0) {
            if ((num & 1) == 1) num--;
            else num = num >> 1;
            out++;
        }
        return out;
    }
}
