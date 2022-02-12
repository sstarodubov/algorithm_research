package com.example.statepattern.state;

import com.example.statepattern.NotificationService;
import com.example.statepattern.ServicesMap;
import com.example.statepattern.Order;

import java.util.Random;

import static com.example.statepattern.state.Common.PAYED_STATE;

public class CreatedState implements State {
    private final Random random = new Random();
    @Override
    public void payOrder(Order order, ServicesMap map) {
        order.setNumber(random.nextInt(0, 1000000));
        order.setPayed(true);
        order.setState(PAYED_STATE);
        System.out.println("order is payed");
        NotificationService notificationService = map.getNotificationService();
        notificationService.sentMessage(order);
    }

    @Override
    public void payTaxes(Order order, ServicesMap map) {
        System.out.println("taxes cannot be payed");
    }
}
