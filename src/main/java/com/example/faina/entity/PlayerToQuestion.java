package com.example.faina.entity;

import javax.persistence.*;

@Entity
@Table
public class PlayerToQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long playerId;
    private Long questionId;

    public PlayerToQuestion (Long playerId, Long questionId) {
        this.playerId = playerId;
        this.questionId = questionId;
    }

}
