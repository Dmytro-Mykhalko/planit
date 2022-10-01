package com.example.planit.entity;


import com.example.planit.entity.enums.BoardAccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "board")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<ColumnEntity> columns;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<UserBoardEntity> userBoard;

}
