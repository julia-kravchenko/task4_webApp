package com.example.controllers;

import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @DeleteMapping("/main")
    public String deleteUser(@RequestParam (value = "activity"),
                             @RequestParam("name") String[] userId) {

        return "main";
    }
}
