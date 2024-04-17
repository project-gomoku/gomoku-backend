package com.gomoku.game.domain.board;

import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.ArrayList;
import java.util.List;

public class BoardLeftwardDiagonal implements BoardLine{
    private final int size;
    private final int boardSize;
    private final List<Stone> leftwardDiagonals = new ArrayList<>();

    public BoardLeftwardDiagonal(int size, int boardSize){
        this.size = size;
        this.boardSize = boardSize;

        for (int i = 0; i < this.size; i++){
            leftwardDiagonals.add(Stone.NONE);
        }
    }

    @Override
    public boolean check(Stone placedStone) {
        int count = 0;

        for (Stone stone : leftwardDiagonals){
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
    public void load(PlacementSequence sequence){
        int height = sequence.getHeight();
        int width = sequence.getWidth();

        int leftwardOrder = (boardSize - 1) - width;

        if (height + (boardSize - 1 - width) > boardSize - 1) {
            leftwardOrder -= height + (boardSize - 1 - width) - (boardSize - 1);
        }

        leftwardDiagonals.set(leftwardOrder,
                Stone.toStone(sequence.getStoneColor()));
    }

}
