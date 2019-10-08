package com.io.project1.demoQualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CarComponent {
    @Autowired
    @Qualifier("carBean")
    private Operation operation;

    public void service() {
        operation.start();
        operation.stop();
    }
}
