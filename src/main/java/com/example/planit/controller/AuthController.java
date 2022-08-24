package com.example.planit.controller;

import com.example.planit.entity.UserEntity;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String getLoginPage() {
        return "html/auth/login";
    }

//    @PostMapping("/login")
//    public String processLogin(@ModelAttribute String email,
//                               @ModelAttribute String password) {
//        System.out.println("Password encoder" + passwordEncoder);
//        System.out.println(email + " " + password);
//        UserEntity user = userService.findByEmail(email)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("Invalid email or password")
//                );
//        log.info("User with email found");
//        if (passwordEncoder.matches(password, user.getPassword())) {
//            log.info("Credentials are OK");
//            return "redirect:/home";
//        } else {
//            throw new BadCredentialsException("Invalid email or password");
//        }
//    }

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        UserEntity user = new UserEntity();
        user.setId(0);
        log.info("Creating a new user: " + user);
        model.addAttribute("user", user);
        return "html/auth/signup";
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute UserEntity user) {
        String email = user.getEmail().toLowerCase();
        if (userService.findByEmail(email).isPresent()) {
            log.info("There is already a user with such email: " + user);
            return "html/auth/signup";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true); // later add mail verification logic
        userService.save(user);
        log.info("Created a new user: " + user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String processLogout(@ModelAttribute UserEntity user) {
        return "redirect:/";
    }
}
