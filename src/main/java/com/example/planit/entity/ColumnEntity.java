package com.example.planit.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "columns")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "column",
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private List<TaskEntity> tasks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private BoardEntity board;

}