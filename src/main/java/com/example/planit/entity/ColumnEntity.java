package com.example.planit.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


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

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "column", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<TaskEntity> tasks;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BoardEntity board;

}