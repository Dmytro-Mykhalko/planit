package com.example.planit.entity;

import com.example.planit.entity.enums.BoardAccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "user_has_board")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false,
            cascade = CascadeType.ALL) // what cascade type should be here
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false,
            cascade = CascadeType.ALL) // what cascade type should be here
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private BoardEntity board;

    @Column(name = "board_access_id")
    @Enumerated(EnumType.STRING)
    private BoardAccessLevel access;

}
