package com.example.labo1ncapas;

import com.example.labo1ncapas.runner.PokedexRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Labo1NCapasApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Labo1NCapasApplication.class, args);
        PokedexRunner runner = ctx.getBean(PokedexRunner.class);
        try {
            runner.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}