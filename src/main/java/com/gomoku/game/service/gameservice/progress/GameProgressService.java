package com.gomoku.game.service.gameservice.progress;

import com.gomoku.game.dto.PlacementDto;

public interface GameProgressService {

    void load(long id);
    long place(long id, PlacementDto dto);

}
