package com.gomoku.game.domain.winnercheck;

import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.domain.board.BoardColumn;
import com.gomoku.game.domain.board.BoardLeftwardDiagonal;
import com.gomoku.game.domain.board.BoardRightwardDiagonal;
import com.gomoku.game.domain.board.BoardRow;
import com.gomoku.game.repository.entity.PlacementSequence;

import java.util.ArrayList;
import java.util.List;

public class RenzuWinnerChecker implements WinnerChecker{

    private final int size;
    private final List<BoardRow> rows = new ArrayList<>();
    private final List<BoardColumn> columns = new ArrayList<>();
    private final List<BoardRightwardDiagonal> rightwardDiagonals = new ArrayList<>();
    private final List<BoardLeftwardDiagonal>  leftwardDiagonals = new ArrayList<>();


    public RenzuWinnerChecker(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            rows.add(new BoardRow(size));
            columns.add(new BoardColumn(size));
        }

        for (int i = 1; i <= size; i++){
            rightwardDiagonals.add(new BoardRightwardDiagonal(i, size));
            leftwardDiagonals.add(new BoardLeftwardDiagonal(i, size));
        }
        for (int i = 1; i < size; i++){
            rightwardDiagonals.add(new BoardRightwardDiagonal(size - i, size));
            leftwardDiagonals.add(new BoardLeftwardDiagonal(size - i, size));
        }
    }

    @Override
    public boolean isWinnerExists(Stone stone){
        return isWinnerExistsInRow(stone)
                || isWinnerExistsInColumn(stone)
                || isWinnerExistsInRightwardDiagonal(stone)
                || isWinnerExistsInLeftwardDiagonal(stone);
    }

    @Override
    public void load(List<PlacementSequence> placementSequences) {
        for (PlacementSequence placementSequence : placementSequences){
            rows.get(placementSequence.getHeight())
                    .load(placementSequence);
            columns.get(placementSequence.getWidth())
                    .load(placementSequence);
            rightwardDiagonals.get(placementSequence.getHeight() + placementSequence.getWidth())
                    .load(placementSequence);
            leftwardDiagonals.get(placementSequence.getHeight() + (size - 1 - placementSequence.getWidth()))
                    .load(placementSequence);
        }
    }

    private boolean isWinnerExistsInRow(Stone stone){
        for (BoardRow row : rows){
            if (row.check(stone)) {
                return true;
            }
        }

        return false;
    }

    private boolean isWinnerExistsInColumn(Stone stone){
        for (BoardColumn column : columns){
            if (column.check(stone)) {
                return true;
            }
        }

        return false;
    }

    private boolean isWinnerExistsInRightwardDiagonal(Stone stone){
        for (BoardRightwardDiagonal diagonal : rightwardDiagonals){
            if (diagonal.check(stone)){
                return true;
            }
        }

        return false;
    }

    private boolean isWinnerExistsInLeftwardDiagonal(Stone stone){
        for (BoardLeftwardDiagonal diagonal : leftwardDiagonals){
            if (diagonal.check(stone)){
                return true;
            }
        }

        return false;
    }

}
