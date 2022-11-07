package com.example.patternsinspring;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PatternsInSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternsInSpringApplication.class, args);
    }

}

enum OrderEvents {
    FULFILL,
    PAY,
    CANCEL
}

enum OrderStates {
    SUBMITTED,
    PAYD,
    FULFILLED,
    CANCELLED
}

@Slf4j
@Component
class Runner implements ApplicationRunner {
    private final StateMachineFactory<OrderStates, OrderEvents> factory;

    Runner(StateMachineFactory<OrderStates, OrderEvents> factory) {
        this.factory = factory;
    }

    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        var t = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("hello " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        Runtime.getRuntime().addShutdownHook(t);


        for (;;) {
            Thread.sleep(2000);
            log.info("do usefull stuff");
        }
    }
}


@Slf4j
@Configuration
@EnableStateMachineFactory
class SimpleEnumStateMachineConfiguration extends StateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions) throws Exception {
        transitions.withExternal().source(OrderStates.SUBMITTED).target(OrderStates.PAYD).event(OrderEvents.PAY)
                .and()
                .withExternal().source(OrderStates.PAYD).target(OrderStates.FULFILLED).event(OrderEvents.FULFILL)
                .and()
                .withExternal().source(OrderStates.SUBMITTED).target(OrderStates.CANCELLED).event(OrderEvents.CANCEL)
                .and()
                .withExternal().source(OrderStates.PAYD).target(OrderStates.CANCELLED).event(OrderEvents.CANCEL);
    }

    @Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) throws Exception {
        states.withStates()
                .initial(OrderStates.SUBMITTED)
                .state(OrderStates.PAYD)
                .end(OrderStates.FULFILLED)
                .end(OrderStates.CANCELLED);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderStates, OrderEvents> config) throws Exception {
        config.withConfiguration()
                .autoStartup(false)
                .listener(new StateMachineListenerAdapter<>() {
                    @Override
                    public void stateChanged(State<OrderStates, OrderEvents> from, State<OrderStates, OrderEvents> to) {
                        log.info("state changed(from:'{}',to:'{}'", from, to);
                    }
                });
    }
}
