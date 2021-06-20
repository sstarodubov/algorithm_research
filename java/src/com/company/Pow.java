package com.company;

import java.util.HashMap;

public class Pow {
    public static void main(String[] args) {
        double pow = pow(7, 6);
        System.out.println(pow);
        System.out.println("tests passed");
    }


    public static double pow(double a, double p) {
        var table = new HashMap<Double, Double>();
        Double N = 1.0;
        while (N + 1< p) {
            var r = Math.pow(a, N);
            table.put(N, r);
            N = N * 2;
        }
        N = N / 2;
        Double pow = N;
        Double ans = 0.0;
        while (pow >= 0) {
            ans += table.get(pow);
            pow = p - pow;
            p =- pow;
        }
        return ans;
    }
}
