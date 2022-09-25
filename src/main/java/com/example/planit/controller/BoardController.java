package com.example.planit.controller;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.service.BoardService;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("")
    public String getBoards(Authentication authentication, Model model) {
        UserEntity user = getUser(authentication);
        List<BoardEntity> boardList = boardService.getBoardList(user);
        BoardEntity newBoard = new BoardEntity();
        newBoard.setId(0);
        newBoard.setUser(user);

        model.addAttribute("user", user);
        model.addAttribute("boards", boardList);
        model.addAttribute("newBoard", newBoard);

        return "html/user/boards";
    }

    @PostMapping("")
    public String addBoard(@ModelAttribute("newBoard") BoardEntity board) {
        board.setColumns(new ArrayList<>());
        boardService.save(board);
        return "redirect:/boards";
    }

    private UserEntity getUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userService.findByEmail(userDetails.getUsername());
    }
}
