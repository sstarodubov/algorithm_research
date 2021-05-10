package com.company;

public class PowerOfTwo {
    public static void main(String[] args) {
        var m = new PowerOfTwo();
        assert !m.isPowerOfTwo(262145): 123123;
        assert m.isPowerOfTwo(536870912): 123;
        assert m.isPowerOfTwo(1) : 0;
        assert m.isPowerOfTwo(16): 1;
        assert m.isPowerOfTwo(8) : 12;
        assert !m.isPowerOfTwo(5) : 11;
        System.out.println("tests passed");
    }

    public boolean isPowerOfTwo(int n) {
        double log = (Math.log(n) / Math.log(2));
        double floor = Math.floor(log);
        double diff =  log - floor ;
        return diff < 0.00000000009;
    }
}
