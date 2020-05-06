package com.example.faina.service;

import com.example.faina.exception.PersistingException;
import com.example.faina.exception.UnknownUserException;

import java.util.HashMap;

public interface GameService {

    Integer guess(String userName, String answer, Long gameId) throws UnknownUserException, PersistingException;

    HashMap<String, Integer> getBoard(Long gameId);
}
