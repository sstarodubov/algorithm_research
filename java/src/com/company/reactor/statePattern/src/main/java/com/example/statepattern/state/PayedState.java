package com.example.statepattern.state;

import com.example.statepattern.NotificationService;
import com.example.statepattern.ServicesMap;
import com.example.statepattern.Order;

import static com.example.statepattern.state.Common.TAXES_PAYED_STATE;

public class PayedState implements State {

    @Override
    public void payOrder(Order order, ServicesMap map) {
        System.out.println("order already payed");
    }

    @Override
    public void payTaxes(Order order, ServicesMap map) {
        order.setTaxesPayed(true);
        order.setState(TAXES_PAYED_STATE);
        NotificationService notificationService = map.getNotificationService();
        notificationService.sentMessage(order);
    }
}
