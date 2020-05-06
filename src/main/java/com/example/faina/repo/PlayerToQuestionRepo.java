package com.example.faina.repo;

import com.example.faina.entity.PlayerToQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public interface PlayerToQuestionRepo extends JpaRepository<PlayerToQuestion, Long> {

    @Query(value = "SELECT player_to_question.player_id, relevant_questions.score " +
            "FROM player_to_question " +
            "JOIN (SELECT id, score from Question where id in :question_ids) relevant_questions " +
            "ON relevant_questions.id=player_to_question.question_id")
    Map<Long, Integer> findScores(@Param("question_ids") Collection<Long> questionIds);
}
