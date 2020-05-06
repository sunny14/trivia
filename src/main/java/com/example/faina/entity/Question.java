package com.example.faina.entity;

import javax.persistence.*;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private Long gameId;

    private Integer score;

    public Long getGameId() {
        return gameId;
    }

    public Integer getScore() {
        return score;
    }
}
