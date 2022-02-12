package com.example.statepattern.state;

import com.example.statepattern.ServicesMap;
import com.example.statepattern.Order;

public interface State {

    void payOrder(Order order, ServicesMap helperService);

    void payTaxes(Order order, ServicesMap helperService);

}



