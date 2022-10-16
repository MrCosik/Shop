package pl.cdp.userws.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private AuthenticationManager authManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

}
