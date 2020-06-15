package com.example.controllers;

//import com.com.example.entity.Role;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setDateRegistration(df.format(calendar.getTime()));
        userRepo.save(user);
        return "redirect:/login";
    }
}
