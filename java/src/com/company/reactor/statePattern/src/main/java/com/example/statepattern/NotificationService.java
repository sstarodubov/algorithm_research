package com.example.statepattern;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sentMessage(Order order) {
        System.out.println("hello  " + order.number + " your state is " + order.state.toString());
    }
}
