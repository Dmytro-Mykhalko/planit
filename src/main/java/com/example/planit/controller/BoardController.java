package com.example.planit.controller;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.ColumnEntity;
import com.example.planit.entity.TaskEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.service.BoardService;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("")
    public String getBoards(Authentication authentication, Model model) {
        UserEntity user = userService.getUserFromAuth(authentication);
        model.addAttribute("user", user);
        model.addAttribute("boards", user.getBoards());
        model.addAttribute("newBoard", new BoardEntity());
        return "html/user/home";
    }

    @PostMapping("")
    public String addBoard(Authentication authentication, @ModelAttribute BoardEntity newBoard) {
        UserEntity user = userService.getUserFromAuth(authentication);
        newBoard.setUser(user);
        boardService.save(newBoard);
        return "redirect:/boards";
    }

    @GetMapping("/{boardName}")
    public String getBoardPage(Authentication authentication,
                               @PathVariable String boardName,
                               Model model) {
        UserEntity user = userService.getUserFromAuth(authentication);
        BoardEntity board = boardService.getBoardByName(user, boardName);
        model.addAttribute("board", board);
        model.addAttribute("columns", board.getColumns());
        model.addAttribute("newColumn", new ColumnEntity());
        model.addAttribute("newTask", new TaskEntity());
        return "html/user/board";
    }
}
