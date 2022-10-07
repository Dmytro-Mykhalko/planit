package com.example.planit.controller;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.ColumnEntity;
import com.example.planit.entity.TaskEntity;
import com.example.planit.service.BoardService;
import com.example.planit.service.ColumnService;
import com.example.planit.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class TaskController {

    private final BoardService boardService;
    private final ColumnService columnService;
    private final TaskService taskService;

    @PostMapping("/{boardId}/{columnId}")
    public String addTask(@PathVariable int boardId,
                          @PathVariable int columnId,
                          @ModelAttribute TaskEntity task) {
        ColumnEntity column = columnService.getById(columnId);
        task.setColumn(column);
        taskService.save(task);
        return String.format("redirect:/boards/%s", boardId);
    }

    @GetMapping("/{boardId}/{columnId}/{taskId}")
    public String getTaskPage(@PathVariable int boardId,
                              @PathVariable int columnId,
                              @PathVariable int taskId,
                              Model model) {
        BoardEntity board = boardService.getById(boardId);
        ColumnEntity column = columnService.getById(columnId);
        TaskEntity task = taskService.getById(taskId);
        model.addAttribute("board", board);
        model.addAttribute("task", task);
        model.addAttribute("column", column);
        return "html/user/task";
    }

    @PatchMapping("/{boardId}/{columnId}")
    public String updateTask(@PathVariable int boardId,
                             @PathVariable int columnId,
                             @ModelAttribute TaskEntity task,
                             @RequestParam int updateColumnId) {
        if (updateColumnId != task.getColumn().getId())
            task.setColumn(columnService.getById(updateColumnId));
        taskService.save(task);
        return String.format("redirect:/boards/%s", boardId);
    }

    @DeleteMapping("/{boardId}/{columnId}")
    public String deleteTask(@PathVariable int boardId,
                             @PathVariable int columnId,
                             @RequestParam int taskId) {
        log.info("Starting delete task: " + taskId);
        taskService.deleteById(taskId);
        log.info("Finished delete");
        return String.format("redirect:/boards/%s", boardId);
    }
}
