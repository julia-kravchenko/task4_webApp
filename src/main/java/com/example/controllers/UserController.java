package com.example.controllers;

import com.example.entity.User;
import com.example.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(value = "/action", params = "action=delete")
    public String deleteUser(@RequestParam("userId") String[] userId) {
        Optional<User> user;

        for (int i = 0; i < userId.length; i++) {
            user = userRepo.findById(Long.parseLong(userId[i]));
            userRepo.delete(user.get());
        }
        return "redirect:/main";
    }

    @PostMapping(value = "/action", params = "action=block")
    public String blockUser(@RequestParam("userId") String[] userId) {
        User user;
        String res = "redirect:/main";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        for (int i = 0; i < userId.length; i++) {
            user = userRepo.findByUserId(Long.parseLong(userId[i]));
            user.setActive(false);
            userRepo.save(user);
            if (user.getUsername().equals(auth.getName()))
                res = "redirect:/login?logout";
        }
        return res;
    }

    @PostMapping(value = "/action", params = "action=unblock")
    public String unblockUser(@RequestParam("userId") String[] userId) {
        User user;
        for (int i = 0; i < userId.length; i++) {
            user = userRepo.findByUserId(Long.parseLong(userId[i]));
            user.setActive(true);
            userRepo.save(user);
        }
        return "redirect:/main";
    }
}
