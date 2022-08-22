package com.example.planit.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<ColumnEntity> columns;

    @ManyToOne
    private UserEntity user;

}
