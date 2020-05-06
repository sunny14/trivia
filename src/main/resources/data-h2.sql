INSERT INTO GAME (id, name) VALUES (1, 'TRIVIA1');
INSERT INTO GAME (id, name) VALUES (2, 'TRIVIA2');

INSERT INTO QUESTION (id, question, game_id, score) VALUES (1, 'what is the answer to life?', 1, 10);

INSERT INTO QUESTION_TO_ANSWER (id, answer, question_id) VALUES (1, '42', 1);