package com.company;

public class AddDigits {
    public static void main(String[] args) {
        var m = new AddDigits();

        assert 2 == m.addDigits(38) : 0;
        assert 0 == m.addDigits(0) : 1;

        System.out.println("tests passed");
    }

    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
