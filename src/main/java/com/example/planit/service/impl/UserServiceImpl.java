package com.example.planit.service.impl;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.repository.BoardRepository;
import com.example.planit.repository.UserRepository;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Override
    public List<UserEntity> findAll() {
        log.info("Getting all the users");
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(int id) {
        log.info("Getting a user by ID: " + id);
        return userRepository.getReferenceById(id);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        log.info("Saving user " + entity);
        return userRepository.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        log.info("Deleting user " + entity.getId());
        userRepository.delete(entity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        log.info("Searching user by email: " + email);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User NOT FUND with email: " + email));
    }

    @Override
    public UserEntity getUserFromAuth(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return findByEmail(userDetails.getUsername());
    }
}
