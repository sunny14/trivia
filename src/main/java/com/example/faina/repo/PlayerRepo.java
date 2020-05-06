package com.example.faina.repo;

import com.example.faina.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepo extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);
}
