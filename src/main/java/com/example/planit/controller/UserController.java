package com.example.planit.controller;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.security.CustomUserDetails;
import com.example.planit.service.BoardService;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String getIndexPage() {
        return "html/index";
    }

    // settings
}
