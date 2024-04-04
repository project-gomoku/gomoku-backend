package com.gomoku.game.domain.board;

import com.gomoku.game.dto.PlacementDto;
import com.gomoku.game.repository.GameBoardRepository;
import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.List;

public interface Board {

    void load(List<PlacementSequence> placementSequences);

}
