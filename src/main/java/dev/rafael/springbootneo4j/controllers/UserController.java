package dev.rafael.springbootneo4j.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    @GetMapping("/me")
    public String loggerInUser ( Principal principal){
        return principal.getName();
    }
}
