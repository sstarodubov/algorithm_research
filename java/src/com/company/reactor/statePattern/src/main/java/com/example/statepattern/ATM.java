package com.example.statepattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ATM {

    @Autowired
    private ServicesMap servicesMap;

    @PostConstruct
    public void test() {
        var order = new Order();
        System.out.println(order.getState());
        order.payOrder(servicesMap);
        order.payTaxes(servicesMap);
        order.payOrder(servicesMap);
        order.payTaxes(servicesMap);
    }
}
