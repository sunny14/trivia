package com.example.faina.entity;

import javax.persistence.*;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    private Long gameId;

    private Integer score;

    public Long getId() {
        return id;
    }

    public Long getGameId() {
        return gameId;
    }

    public Integer getScore() {
        return score;
    }
}
