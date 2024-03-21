package com.gomoku.game.repository;

import com.gomoku.game.repository.entity.GameBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {
}
