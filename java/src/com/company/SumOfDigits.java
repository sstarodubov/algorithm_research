package com.company;

public class SumOfDigits {
    public static void main(String[] args) {
        assert sumOfDigits(123) == 6;
        assert sumOfDigits(10) == 1;
        assert sumOfDigits(111) == 3;

        System.out.println("tests passed");
    }

    public static int sumOfDigits1(int num) {
        var sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public static int sumOfDigits2(int num) {
        if (num <= 9) return num;
        return num % 10 + sumOfDigits(num / 10);
    }

    public static int sumOfDigits(int num) {
        return tailRec(num, 0);
    }

    private static int tailRec(int n, int tail) {
        if (n == 0) return tail;
        tail += n % 10;
        return tailRec(n / 10, tail);
    }
}
