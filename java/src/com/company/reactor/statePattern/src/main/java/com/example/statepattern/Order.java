package com.example.statepattern;

import com.example.statepattern.state.State;
import lombok.Data;

import static com.example.statepattern.state.Common.CREATED_STATE;

@Data
public class Order {

    int number;
    boolean isPayed;
    boolean isTaxesPayed;
    State state = CREATED_STATE;

    public void payOrder(ServicesMap map) {
        state.payOrder(this, map);
    }

    public void payTaxes(ServicesMap map) {
        state.payTaxes(this, map);
    }
}
