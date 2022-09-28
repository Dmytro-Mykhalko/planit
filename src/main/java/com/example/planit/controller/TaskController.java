package com.example.planit.controller;

import com.example.planit.entity.ColumnEntity;
import com.example.planit.entity.TaskEntity;
import com.example.planit.service.ColumnService;
import com.example.planit.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class TaskController {
    private final ColumnService columnService;
    private final TaskService taskService;

    // add a user authentication
    @PostMapping("/{boardName}/{columnId}")
    public String addTask(@PathVariable String boardName,
                          @PathVariable int columnId,
                          @ModelAttribute TaskEntity task) {
        ColumnEntity column = columnService.getById(columnId);
        task.setColumn(column);
        taskService.save(task);
        return String.format("redirect:/boards/%s", boardName);
    }
}
