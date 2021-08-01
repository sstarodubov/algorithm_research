package com.company.patterns.adapter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var list = new ArrayList<Duckable>();

        list.add(new Duck());
        list.add(new Duck());
        list.add(new GooseAdapter(new Goose()));

        list.forEach(Duckable::quack);

    }
}

class GooseAdapter implements Duckable {

    private final Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}

interface Duckable {
    void quack();
}


class Duck implements Duckable {

    @Override
    public void quack() {
        System.out.println("quack");
    }
}

class Goose {
    void honk() {
        System.out.println("honk");
    }
}
