package com.gomoku.game.service.gameservice.progress;

import com.gomoku.common.enumeration.Status;
import com.gomoku.game.dto.PlacementDto;
import com.gomoku.game.repository.entity.GameBoard;

public interface GameProgressService {

    void load(long id);
    long place(long id, PlacementDto dto);
    Status winnerCheck(long id);

}
