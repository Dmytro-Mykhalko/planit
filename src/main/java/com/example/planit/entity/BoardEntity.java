package com.example.planit.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<ColumnEntity> columns;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserEntity user;
}