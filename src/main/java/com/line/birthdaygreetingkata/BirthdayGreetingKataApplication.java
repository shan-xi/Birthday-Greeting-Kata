package com.line.birthdaygreetingkata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BirthdayGreetingKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirthdayGreetingKataApplication.class, args);
    }
}