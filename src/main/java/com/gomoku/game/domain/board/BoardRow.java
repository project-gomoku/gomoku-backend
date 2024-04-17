package com.gomoku.game.domain.board;

import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.ArrayList;
import java.util.List;

public class BoardRow implements BoardLine{

    private final int size;
    private final List<Stone> column;

    public BoardRow(int size){
        this.size = size;
        column = new ArrayList<>();

        for (int width = 0; width < this.size; width++){
            column.add(Stone.NONE);
        }
    }

    public boolean check(Stone placedStone){
        int count = 0;

        for (Stone stone : column){
            if (stone.isEqualTo(placedStone)){
                count++;
            } else {
                count = 0;
            }

            if (count == 5){
                return true;
            }
        }
        System.out.println();
        return false;
    }

    @Override
    public void load(PlacementSequence placementSequences) {
        this.column.set(placementSequences.getWidth(),
                Stone.toStone(placementSequences.getStoneColor()));
    }

}
