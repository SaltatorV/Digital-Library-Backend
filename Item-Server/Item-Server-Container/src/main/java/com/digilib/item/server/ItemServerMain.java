package com.digilib.item.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.digilib.item.server"})
public class ItemServerMain {
    public static void main(String[] args) {
        SpringApplication.run(ItemServerMain.class, args);
    }
}
