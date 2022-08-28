package com.example.greetingproject.service;



import java.util.concurrent.atomic.AtomicLong;

import com.example.greetingproject.model.Greeting;
import org.springframework.stereotype.Service;



@Service
public class GreetingService implements IGreetingService {

    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting greetingMessage() {

        return new Greeting(counter.incrementAndGet(), String.format(template));
    }



}