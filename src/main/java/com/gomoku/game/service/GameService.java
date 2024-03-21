package com.gomoku.game.service;


import com.gomoku.game.dto.GameBoardDto;
import com.gomoku.game.repository.entity.GameBoard;

public interface GameService {

    GameBoard initialize(GameBoardDto gameBoardDto);

}
