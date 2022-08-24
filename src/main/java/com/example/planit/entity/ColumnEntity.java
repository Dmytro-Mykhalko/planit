package com.example.planit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
                fetch = FetchType.EAGER)
    private List<TaskEntity> tasks;

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false,
            cascade = CascadeType.ALL)
    private BoardEntity board;

}