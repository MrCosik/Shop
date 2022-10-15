package pl.cdp.userws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/login")
    public String login(){
        return "Hello";
    }
}
