package com.example.statepattern.state;

import com.example.statepattern.ServicesMap;
import com.example.statepattern.Order;

public class TaxesPayedState implements State {

    @Override
    public void payOrder(Order order, ServicesMap map) {
        System.out.println("order is done");
    }

    @Override
    public void payTaxes(Order order, ServicesMap map) {
        System.out.println("taxes is done");
    }
}
