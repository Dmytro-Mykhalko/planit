package com.example.planit.repository;

import com.example.planit.entity.UserBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBoardRepository extends JpaRepository<UserBoardEntity, Integer> {

}
