package com.example.enoca;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnocaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnocaApplication.class, args);
    }

    @Bean // Spring IoC container'ına bean olarak ekler.
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
