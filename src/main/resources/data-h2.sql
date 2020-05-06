INSERT INTO GAME (id, name) VALUES (1, 'TRIVIA1');
INSERT INTO GAME (id, name) VALUES (2, 'TRIVIA2');

INSERT INTO QUESTION (id, question, game_id, score) VALUES (1, 'what is the answer to life?', 1, 10);

CREATE SEQUENCE HIBERNATE_SEQUENCE
    INCREMENT 1
    START 100;
INSERT INTO QUESTION_TO_ANSWER (id, answer, question_id) VALUES (nextval('HIBERNATE_SEQUENCE'), '42', 1);
INSERT INTO QUESTION_TO_ANSWER (id, answer, question_id) VALUES (nextval('HIBERNATE_SEQUENCE'), 'Who knows', 1);

INSERT INTO PLAYER (id, name) VALUES (1, 'Bob');
INSERT INTO PLAYER (id, name) VALUES (2, 'Alice');