package org.example;

import java.util.function.Function;

public class Currying {
    public static void main(String[] args) {
        var res = sum(1).apply(2).apply(3);
        System.out.println(res);
    }

    static Function<Integer, Function<Integer, Integer>> sum(int a) {
       return (x) -> (y) ->  x + a + y;
    }
}
