package com.example.planit.controller;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.ColumnEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.service.BoardService;
import com.example.planit.service.ColumnService;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class ColumnController {

    private final UserService userService;
    private final BoardService boardService;
    private final ColumnService columnService;

    @PostMapping("/{boardName}")
    public String addColumn(Authentication authentication,
                            @PathVariable String boardName,
                            @ModelAttribute ColumnEntity column) {
        UserEntity user = userService.getUserFromAuth(authentication);
        BoardEntity board = boardService.getBoardByName(user, boardName);
        column.setBoard(board);
        columnService.save(column);
        return String.format("redirect:/boards/%s", boardName);
    }
}
