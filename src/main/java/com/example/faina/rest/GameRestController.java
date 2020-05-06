package com.example.faina.rest;

import com.example.faina.rest.entity.Guess;
import com.example.faina.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/game", method = RequestMethod.POST)
public class GameRestController {

    private static Logger logger = LoggerFactory.getLogger(GameRestController.class);

    @Autowired
    private GameService gameService;

    @PostMapping(value = "/guess", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postJson(@RequestBody Guess guess)   {

        logger.info(
                "rest controller got a guess:\n["+guess.getAnswer()+"] from user "+guess.getUserName()+" in game "+guess.getGameId()
        );

        try {
            Integer score = gameService.guess(guess.getUserName(), guess.getAnswer(), guess.getGameId());
            logger.info("score is "+score);
            return ResponseEntity.ok(score);
        }catch (Throwable th)   {
            logger.error(th.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping(value = "/board")
    public ResponseEntity getLeaderboard(@RequestParam Long gameId)  {
        return ResponseEntity.ok(gameService.getBoard(gameId));
    }


}
