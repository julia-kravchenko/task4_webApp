package com.example.controllers;

import com.example.entity.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @DeleteMapping("/action")
    public String deleteUser(@RequestParam("userId") String[] userId) {
        Optional<User> user;
        for (int i = 0; i < userId.length; i++) {
            user = userRepo.findById(Long.parseLong(userId[i]));
            userRepo.delete(user.get());
        }
        return "main";
    }

  /*  @PostMapping("/main")
        public String accessUser(@RequestParam (value = "activity")) {

            return "main";
        }
    }*/
}
