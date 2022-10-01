package com.example.planit.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "task")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ColumnEntity column;
}