package com.example.statepattern;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ServicesMap {

    @Autowired
    public NotificationService notificationService;
}
