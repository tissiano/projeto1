package com.io.project1.demoQualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("motorcycleBean")
public class Motorcycle implements Operation {

    @Override
    public void start() {
        System.out.println("Iniciando Motocicleta");
    }

    @Override
    public void stop() {
        System.out.println("Parando Motocicleta");
    }
}
