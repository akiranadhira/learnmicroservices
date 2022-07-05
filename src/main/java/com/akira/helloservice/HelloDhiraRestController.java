package com.akira.helloservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDhiraRestController {

    @GetMapping( value = "/hello" )
    public String sayHello() {
        return "Hello Dhira, Welcome to start learning Microservice :)";
    }
}
