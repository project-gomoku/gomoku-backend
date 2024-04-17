package com.gomoku.game.domain.board;

import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.List;

public interface BoardLine {

    boolean check(Stone placedStone);
    void load(PlacementSequence placementSequences);

}
