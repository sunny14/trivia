DROP TABLE IF EXISTS GAME;
DROP TABLE IF EXISTS QUESTION;
DROP TABLE IF EXISTS QUESTION_TO_ANSWER;

CREATE TABLE GAME
        (
        id NUMBER(10) NOT NULL,
        name VARCHAR2(50) NOT NULL,
        PRIMARY KEY(id)
        );

CREATE TABLE QUESTION
        (
        id NUMBER(10) NOT NULL,
        question VARCHAR2(50) NOT NULL,
        game_id NUMBER(10),
        score NUMBER(5),
        PRIMARY KEY(id),
        FOREIGN KEY (game_id) REFERENCES GAME(id)
        );

CREATE TABLE QUESTION_TO_ANSWER
        (
        id NUMBER(10) NOT NULL,
        answer VARCHAR2(50) NOT NULL,
        question_id NUMBER(10),
        PRIMARY KEY(id),
        FOREIGN KEY (question_id) REFERENCES QUESTION(id),
        UNIQUE(answer, question_id)
        );