package com.example.faina.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestionToAnswer {

    @Id
    @GeneratedValue
    private Long id;

    private Long questionId;

    private String answer;

    public Long getQuestionId() {
        return questionId;
    }
}
