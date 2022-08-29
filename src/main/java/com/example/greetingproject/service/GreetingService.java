package com.example.greetingproject.service;
import com.example.greetingproject.model.Greeting;
import com.example.greetingproject.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService  {
  @Autowired
    public Repo repository;
    public String helloWorld() {
        return "Hello World.";
    }

    public String greetMessageWithUser(String firstName, String lastName) {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return helloWorld();
        } else if (lastName.equals("") && !firstName.equals("")) {
            return "Hello " + firstName ;
        } else if (!lastName.equals("") && firstName.equals("")) {
            return "Hello " + lastName ;
        }
        return "Hello " + firstName +" "+ lastName ;
    }
    public Greeting greetingMessage(Greeting greeting){
         repository.save(greeting);
         return greeting;
    }
}




