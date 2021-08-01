package com.company.patterns.decorator;

public class Main {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        Mocha mocha = new Mocha(espresso);
        System.out.println(mocha.getDescription());
        System.out.println(mocha.cost());
    }
}


abstract class Beverage {
    String description = "unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();
}

class Espresso extends Beverage {

    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.00;
    }
}

class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha (Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.12;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}


