package com.example.faina.config;


import com.example.faina.service.GameService;
import com.example.faina.service.GameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {


    @Bean
    public GameService getGameService() {
        return new GameServiceImpl();
    }

}
