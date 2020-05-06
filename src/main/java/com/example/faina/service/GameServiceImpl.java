package com.example.faina.service;

import com.example.faina.entity.Question;
import com.example.faina.entity.QuestionToAnswer;
import com.example.faina.repo.QuestionRepo;
import com.example.faina.repo.QuestionToAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GameServiceImpl implements GameService {


    private static final int WRONG_ANSWER_SCORE = 0;
    @Autowired
    private QuestionRepo qRepo;

    @Autowired
    private QuestionToAnswerRepo q2aRepo;

    @Override
    public Integer guess(String userName, String answer, Long gameId) {
        int score = getScore(answer, gameId);

        //TODO: increment player's score

        return score;
    }

    private int getScore(String answer, Long gameId) {
        int score = WRONG_ANSWER_SCORE;
        Optional<QuestionToAnswer> q2a = q2aRepo.findByAnswer(answer);
        //if the given answer exists
        if (q2a.isPresent()) {
            Long questionId = q2a.get().getQuestionId();
            score = getScoreByQuestionId(gameId, questionId);
        }

        return score;
    }

    /**
     * finds score by question id, verifies game id
     * @param gameId
     * @param questionId
     * @return score
     */
    private int getScoreByQuestionId(Long gameId, Long questionId) {
        Optional<Question> question = qRepo.findById(questionId);
        if (question.isPresent() && question.get().getGameId() == gameId)   {
            return question.get().getScore();
        }

        return WRONG_ANSWER_SCORE;
    }
}
