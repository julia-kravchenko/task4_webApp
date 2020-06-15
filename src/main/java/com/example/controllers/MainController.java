package com.example.controllers;

import com.example.entity.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(/*@RequestParam(required = false, defaultValue = "") String filter,*/ Model model) {
        Iterable<User> users = userRepo.findAll();

       /* if (filter != null && !filter.isEmpty()) {
            users = userRepo.findByName(filter);
        } */
     /*  else {
            users = userRepo.findAll();
        }*/
        model.addAttribute("users", users);
      //  model.addAttribute("filter", filter);

        return "main";
    }

  /*  @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam String email, Map<String, Object> model) {
        User user = new User(name, email);

        userRepo.save(user);

        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }*/
}