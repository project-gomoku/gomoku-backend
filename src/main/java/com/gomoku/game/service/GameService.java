package com.gomoku.game.service;


import com.gomoku.game.dto.GameBoardInitializeDto;
import com.gomoku.game.repository.entity.GameBoard;

public interface GameService {

    GameBoard initialize(GameBoardInitializeDto gameBoardDto);

}
