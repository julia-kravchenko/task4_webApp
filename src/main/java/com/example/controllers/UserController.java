package com.example.controllers;

import com.example.entity.User;
import com.example.repositories.CurrentUser;
import com.example.repositories.UserDetailsImpl;
import com.example.repositories.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String blockUser(@RequestParam("userId") String[] userId, @AuthenticationPrincipal User us) {
        Optional<User> user;
       /* User userInfo = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();*/
       System.out.println("USERDETAILSIMPL" + us.getId());
        for (int i = 0; i < userId.length; i++) {
            user = userRepo.findById(Long.parseLong(userId[i]));
            if(user.get().getId().equals(us.getId()))
                return "login?logout";
            user.get().setActive(false);
            userRepo.save(user.get());
        }

        return "redirect:/main";
    }

    @PostMapping(value = "/action", params = "action=unblock")
    public String unblockUser(@RequestParam("userId") String[] userId) {
        Optional<User> user;
        for (int i = 0; i < userId.length; i++) {
            user = userRepo.findById(Long.parseLong(userId[i]));
            user.get().setActive(true);
            userRepo.save(user.get());
        }
        return "redirect:/main";
    }
}
