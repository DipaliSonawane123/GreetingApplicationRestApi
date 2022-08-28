package com.example.greetingproject.controller;
import com.example.greetingproject.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {
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
    @Autowired
    GreetingService greetingService;
    @GetMapping("/service")
    public String serviceCall() {
        return greetingService.helloWorld();
    }
    @GetMapping("/user")
    public String greetMessageWithUser(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return greetingService.greetMessageWithUser(firstName, lastName);
    }

}
