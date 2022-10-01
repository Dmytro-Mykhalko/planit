package com.example.planit.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "board",
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private List<ColumnEntity> columns;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @ToString.Exclude
    private UserEntity user;
}