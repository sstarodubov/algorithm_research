package com.company.patterns.state;

public class Main {

    public static void main(String[] args) {
        var gumbelMachine = new GumbelMachine(10);
        gumbelMachine.insertQuarter();
        gumbelMachine.turnCrank();
        System.out.println(gumbelMachine.state);


    }
}


interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}

class GumbelMachine {

    State soulOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    public State state;
    public int count;

    public GumbelMachine(int count) {
        this.hasQuarterState = new HasQuarterState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.soldState = new SoldState(this);
        this.soulOutState = new SoldOutState(this);
        this.count = count;
        this.state = this.noQuarterState;
    }

    void releaseBall() {
        this.count--;
    }

    void insertQuarter() {
        state.insertQuarter();
    }

    void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void dispense() {
        state.dispense();
    }
}

class SoldOutState implements State {

    GumbelMachine gumbelMachine;

    public SoldOutState(GumbelMachine gumbelMachine) {
        this.gumbelMachine = gumbelMachine;
    }

    @Override
    public void insertQuarter() {
    }

    @Override
    public void ejectQuarter() {
    }

    @Override
    public void turnCrank() {
    }

    @Override
    public void dispense() {
    }
}

class SoldState implements State {

    GumbelMachine gumbelMachine;

    public SoldState(GumbelMachine gumbelMachine) {
        this.gumbelMachine = gumbelMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {
        gumbelMachine.releaseBall();
        if (gumbelMachine.count > 0) {
            System.out.println("switch to noQuarterState");
            gumbelMachine.state = gumbelMachine.noQuarterState;
        } else {
            System.out.println("switch to soldOutState");
            gumbelMachine.state = gumbelMachine.soulOutState;
        }
    }
}

class HasQuarterState implements State {

    GumbelMachine gumbelMachine;

    public HasQuarterState(GumbelMachine gumbelMachine) {
        this.gumbelMachine = gumbelMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {
        System.out.println("switch to soldState");
        this.gumbelMachine.state = gumbelMachine.soldState;
    }

    @Override
    public void dispense() {

    }
}

class NoQuarterState implements State {

    GumbelMachine gumbelMachine;

    public NoQuarterState(GumbelMachine gumbelMachine) {
        this.gumbelMachine = gumbelMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("switch state to HasQuarterState");
        gumbelMachine.state = gumbelMachine.hasQuarterState;
    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}