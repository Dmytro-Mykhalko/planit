package com.example.planit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class UserController {

    @GetMapping("/")
    public String getIndexPage() {
        return "html/index";
    }

    // settings
}
