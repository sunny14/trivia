package com.example.faina.entity;

import javax.persistence.*;

@Entity
@Table
public class QuestionToAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long questionId;

    private String answer;

    public Long getQuestionId() {
        return questionId;
    }
}
