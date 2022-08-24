package com.example.planit.controller;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.service.BoardService;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String getIndexPage() {
        return "html/index";
    }

    @GetMapping("/home")
    public String getBoards(@ModelAttribute UserEntity user, Model model) {
        List<BoardEntity> boardList = userService.getBoardList(user);
        model.addAttribute("user", user);
        model.addAttribute("boards", boardList);
        return "html/user/home";
    }


}
