package com.example.planit.controller;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.service.BoardService;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/users/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.save(user));
    }

    @PostMapping("/new_board")
    public ResponseEntity<?> saveBoard(@RequestBody BoardEntity board,
                                                 @RequestBody UserEntity user) {
        userService.addBoard(user, board);
        return ResponseEntity.ok().build();
    }
}
