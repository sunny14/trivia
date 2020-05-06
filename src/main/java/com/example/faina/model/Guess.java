package com.example.faina.model;

public class Guess {
    String userName;
    Long gameId;
    String answer;

    public String getUserName() {
        return userName;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

        /*public Guess(String uName, Long gameId, String answer) {
            this.userName = uName;
            this.gameId = gameId;
            this.answer = answer;
        }*/
}
