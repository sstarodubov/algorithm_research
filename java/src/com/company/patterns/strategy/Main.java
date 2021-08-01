package com.company.patterns.strategy;

public class Main {
    public static void main(String[] args) {
        var duck = new Duck(() -> System.out.println("fly"), () -> System.out.println("quack"));
        duck.fly();
        duck.quack();
    }
}

interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    void quack() {
        quackBehavior.quack();
    }

    void fly() {
        flyBehavior.fly();
    }
}
