package com.example.faina.entity;

import javax.persistence.*;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    //@ForeignKey(name = "game.id")
    private Long gameId;

    private Integer score;
}
