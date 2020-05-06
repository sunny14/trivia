package com.example.faina.service;

import com.example.faina.exception.PersistingException;
import com.example.faina.exception.UnknownUserException;

public interface GameService {

    Integer guess(String userName, String answer, Long gameId) throws UnknownUserException, PersistingException;
}
