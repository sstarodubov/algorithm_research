package org.example;

import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class FunctionalComposition {
    public static void main(String[] args) {
        // example
        Predicate<Integer> big = x -> x > 1000;
        Predicate<Integer> even = x -> x % 2 == 0;
        // functional composition
        Predicate<Integer> bigAndEven = x -> big.test(x) && even.test(x);
        System.out.println(bigAndEven.test(10002));


        // another example
        IntUnaryOperator triple = x -> x * 3;
        IntUnaryOperator square = x -> x * x;
        // func composition
        IntUnaryOperator squareAfterTriple = triple.andThen(square);
        System.out.println(squareAfterTriple.applyAsInt(3));
    }
}
