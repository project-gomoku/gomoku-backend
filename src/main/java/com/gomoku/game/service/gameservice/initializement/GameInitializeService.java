package com.gomoku.game.service.gameservice.initializement;


import com.gomoku.game.dto.GameBoardInitializeDto;
import com.gomoku.game.dto.PlacementDto;
import com.gomoku.game.repository.entity.GameBoard;

public interface GameInitializeService {

    GameBoard initialize(GameBoardInitializeDto gameBoardDto);


}
