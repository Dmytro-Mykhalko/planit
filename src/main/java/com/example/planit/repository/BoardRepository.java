package com.example.planit.repository;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM board " +
                    "WHERE user_id=:user_id AND name=:board_name LIMIT 1")
    Optional<BoardEntity> findByUserAndName(@Param("user_id") int userId,
                                           @Param("board_name") String boardName);
}