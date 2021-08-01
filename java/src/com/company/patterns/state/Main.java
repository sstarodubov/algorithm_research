package com.company.patterns.state;

public class Main {

    public static void main(String[] args) {
        var gumbelMachine = new GumbelMachine(1);
        gumbelMachine.insertQuarter();
        gumbelMachine.turnCrank();
        gumbelMachine.dispense();
        gumbelMachine.dispense();
        gumbelMachine.insertQuarter();
        gumbelMachine.refill(11);
        System.out.println(gumbelMachine.count);
        System.out.println(gumbelMachine.state);


    }
}


interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    void refill(int count);
}

class GumbelMachine {

    State soulOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State refillState;

    public State state;
    public int count;

    public GumbelMachine(int count) {
        this.hasQuarterState = new HasQuarterState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.soldState = new SoldState(this);
        this.soulOutState = new SoldOutState(this);
        this.refillState = new RefillState(this);

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

    public void refill(int count) {
        state.refill(count);
    }
}


class RefillState implements State {

    GumbelMachine gumbelMachine;

    public RefillState (GumbelMachine gumbelMachine) {
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

    @Override
    public void refill(int count) {
        System.out.println("switch to noQuarterState");
        gumbelMachine.count = count;
        gumbelMachine.state = gumbelMachine.noQuarterState;
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
        if (gumbelMachine.count > 0) {
            gumbelMachine.state = gumbelMachine.noQuarterState;
        } else {
            gumbelMachine.state = gumbelMachine.refillState;
        }
    }

    @Override
    public void refill(int count) {

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

    @Override
    public void refill(int count) {

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

    @Override
    public void refill(int count) {

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

    @Override
    public void refill(int count) {

    }
}