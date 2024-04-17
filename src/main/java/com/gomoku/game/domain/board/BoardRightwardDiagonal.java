package com.gomoku.game.domain.board;

import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.ArrayList;
import java.util.List;

public class BoardRightwardDiagonal implements BoardLine {

    private final int size;
    private final int boardSize;
    private final List<Stone> rightwardDiagonals = new ArrayList<>();

    public BoardRightwardDiagonal(int size, int boardSize){
        this.size = size;
        this.boardSize = boardSize;

        for (int i = 0; i < this.size; i++){
            rightwardDiagonals.add(Stone.NONE);
        }
    }

    @Override
    public boolean check(Stone placedStone) {
        int count = 0;

        for (Stone stone : rightwardDiagonals){
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

        int rightwardOrder = width;

        if (height + width > boardSize - 1) {
            rightwardOrder -= (height + width - (boardSize - 1));
        }

        rightwardDiagonals.set(rightwardOrder,
                Stone.toStone(sequence.getStoneColor()));
    }

}
