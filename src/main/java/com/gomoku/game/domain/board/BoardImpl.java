package com.gomoku.game.domain.board;

import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.List;

public class BoardImpl implements Board {

    private int[][] board;

    public BoardImpl(int size){
        board = new int[size+1][size+1];
    }

    @Override
    public void load(List<PlacementSequence> placementSequences) {
        for (PlacementSequence placementSequence : placementSequences) {
            String stoneColor = placementSequence.getStoneColor();
            int height = placementSequence.getHeight();
            int width = placementSequence.getWidth();

            int color = 1;
            if (stoneColor.equals("white")) {
                color = 2;
            }

            board[height][width] = color;
        }
    }
}
