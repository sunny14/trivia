package com.example.faina.repo;

import com.example.faina.entity.PlayerToQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PlayerToQuestionRepo extends JpaRepository<PlayerToQuestion, Long> {

}
