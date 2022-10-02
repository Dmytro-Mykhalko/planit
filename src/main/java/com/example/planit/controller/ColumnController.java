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
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class ColumnController {

    private final UserService userService;
    private final BoardService boardService;
    private final ColumnService columnService;

    @PostMapping("/{boardId}")
    public String addColumn(@PathVariable int boardId, @ModelAttribute ColumnEntity column) {
        BoardEntity board = boardService.getById(boardId);
        column.setBoard(board);
        columnService.save(column);
        return String.format("redirect:/boards/%s", boardId);
    }

    @DeleteMapping("/{boardId}")
    public String deleteColumn(@PathVariable int boardId, @RequestParam int columnId) {
        columnService.deleteById(columnId);
        return String.format("redirect:/boards/%s", boardId);
    }

    @PatchMapping("/{boardId}")
    public String updateColumnName(@PathVariable int boardId, @RequestParam int columnId,
                                   @RequestParam String newColumnName) {
        ColumnEntity columnToUpdate = columnService.getById(columnId);
        columnToUpdate.setName(newColumnName);
        columnService.save(columnToUpdate);
        return String.format("redirect:/boards/%s", boardId);
    }
}
