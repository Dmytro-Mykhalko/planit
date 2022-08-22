package com.example.planit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "column",
                fetch = FetchType.EAGER)
    private List<TaskEntity> tasks;

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false,
            cascade = CascadeType.ALL)
    private BoardEntity board;

}