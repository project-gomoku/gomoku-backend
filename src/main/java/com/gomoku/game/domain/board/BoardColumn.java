package com.gomoku.game.domain.board;

import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.ArrayList;
import java.util.List;

public class BoardColumn implements BoardLine {
    private final int size;
    private final List<Stone> row;

    public BoardColumn(int size){
        this.size = size;
        row = new ArrayList<>();

        for (int width = 0; width < this.size; width++){
            row.add(Stone.NONE);
        }
    }

    public boolean check(Stone placedStone){
        int count = 0;

        for (Stone stone : row){
            if (stone.isEqualTo(placedStone)){
                count++;
            } else {
                count = 0;
            }

            if (count == 5){
                return true;
            }
        }

        return false;
    }

    @Override
    public void load(PlacementSequence placementSequences) {
        this.row.set(placementSequences.getHeight(),
                Stone.toStone(placementSequences.getStoneColor()));
    }
}
