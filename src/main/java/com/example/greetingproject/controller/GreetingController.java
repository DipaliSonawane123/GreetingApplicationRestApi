package com.example.greetingproject.controller;
import com.example.greetingproject.model.Greeting;
import com.example.greetingproject.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    @Autowired
    GreetingService greetingService;
    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String greet() {
        return "Hello, this is Dipali from Jalgaon";
    }

    @RequestMapping("/query/{name}")
    public String greet1(@PathVariable String name) {
        return "<h1><font color=purple>Hello! This is " + name + " From Jalgaon!</font></h1>" +
                "</br> <font color=green>Passing name as a path variable.</font>";
    }

    @GetMapping("/query")
    public String getUsers(@RequestParam(value = "name", defaultValue = "Dipali") String name) {
        return "<h1><font color=red>Hello! This is " + name + " From Jalgaon!</font></h1>" +
                "</br> <font color=black>Passing name as a parameter.</font>";
    }
    /*
    Extending GreetingController to use Services Layer to get Simple Greeting message
     */

    @GetMapping("/service")
    public String serviceCall() {
        return greetingService.helloWorld();
    }
    @GetMapping("/user")
    public String greetMessageWithUser(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return greetingService.greetMessageWithUser(firstName, lastName);
    }
    @PostMapping("/post")
    public Greeting addGreeting(@RequestBody Greeting greeting){
         greetingService.greetingMessage(greeting);
    return greeting;
    }
    @GetMapping("/get/{id}")
    public Optional<Greeting> sayHelloById(@PathVariable long id){
        Optional<Greeting> response = greetingService.sayHelloById(id);
        return response;
    }
    @GetMapping("/findAll")
    public List<Greeting> sayToAll (){
        List<Greeting> response = greetingService.sayAll();
        return response;
    }
    @PutMapping("/edit/{id}")
    public Greeting editId(@RequestBody Greeting greeting, @PathVariable long id){
        greetingService.editGreeting(greeting, id);
        return greeting;
    }
}
