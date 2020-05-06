package com.example.faina.repo;

import com.example.faina.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    List<Question> findAllByGameId(Long gameId);

}
