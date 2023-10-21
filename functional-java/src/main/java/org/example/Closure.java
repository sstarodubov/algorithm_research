package org.example;

import java.util.function.IntUnaryOperator;

public class Closure {
    public static void main(String[] args) {
        var adder = add10();
//        System.out.println(adder.applyAsInt(1));
        var adderN = addN();
        System.out.println(adderN.applyAsInt(13));
    }

    static IntUnaryOperator addN() {
        int y = 9;
        return x -> x + y;
    }

    static IntUnaryOperator add10() {
        return x -> x + 10;
    }
}
