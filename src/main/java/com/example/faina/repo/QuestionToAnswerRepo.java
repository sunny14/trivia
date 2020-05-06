package com.example.faina.repo;

import com.example.faina.entity.QuestionToAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionToAnswerRepo extends JpaRepository<QuestionToAnswer, Long> {
    Optional<QuestionToAnswer> findByAnswer(String answer);
}
