package com.example.planit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "column")
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

    @Column(name = "order")
    private Integer order;

    @OneToMany(mappedBy = "column",
                fetch = FetchType.EAGER)
    private List<TaskEntity> tasks;

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private BoardEntity board;

}