package com.example.faina.service;

import com.example.faina.entity.Player;
import com.example.faina.entity.PlayerToQuestion;
import com.example.faina.entity.Question;
import com.example.faina.entity.QuestionToAnswer;
import com.example.faina.exception.PersistingException;
import com.example.faina.exception.UnknownUserException;
import com.example.faina.repo.PlayerRepo;
import com.example.faina.repo.PlayerToQuestionRepo;
import com.example.faina.repo.QuestionRepo;
import com.example.faina.repo.QuestionToAnswerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

public class GameServiceImpl implements GameService {

    private static Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

    private static final int WRONG_ANSWER_SCORE = 0;
    @Autowired
    private QuestionRepo qRepo;

    @Autowired
    private QuestionToAnswerRepo q2aRepo;

    @Autowired
    private PlayerToQuestionRepo playerToQuestionRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public Integer guess(String playerName, String answer, Long gameId) throws UnknownUserException, PersistingException {
        int score = getScore(playerName, answer, gameId);

        return score;
    }

    private int getScore(String playerName, String answer, Long gameId) throws UnknownUserException, PersistingException {
        int score = WRONG_ANSWER_SCORE;
        Optional<QuestionToAnswer> q2a = q2aRepo.findByAnswer(answer);
        //if the given answer exists
        if (q2a.isPresent()) {
            Long questionId = q2a.get().getQuestionId();
            persistAnswer(playerName, questionId);
            score = getScoreByQuestionId(gameId, questionId);
        }

        return score;
    }

    private void persistAnswer(String playerName, Long questionId) throws UnknownUserException, PersistingException {
        logger.info("persisting the right answer for "+playerName+", question "+questionId);
        Optional<Player> player = playerRepo.findByName(playerName);
        if (!player.isPresent())    {
            String errMsg = "unknown player: "+playerName;
            logger.error(errMsg);
            throw new UnknownUserException(errMsg);
        }
        try {
            PlayerToQuestion p2q = new PlayerToQuestion(player.get().getId(), questionId);
            playerToQuestionRepo.save(p2q);
        }catch (Exception ex)    {
            logger.error(ex.getMessage());
            throw new PersistingException("cannot save the answer");
        }
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
