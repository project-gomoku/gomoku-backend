package com.gomoku.game.dto;

import com.gomoku.common.enumeration.Status;
import com.gomoku.game.repository.entity.GameBoard;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GameBoardInitializeDto {

    private long id;
    private long blackUserId;
    private long whiteUserId;
    private String blackUserName;
    private String whiteUserName;
    private int status;
    private int boardSize;

    @Builder
    public GameBoardInitializeDto(long blackUserId, long whiteUserId, String blackUserName, String whiteUserName,
                                  int status, int boardSize)
    {
        this.blackUserId = blackUserId;
        this.whiteUserId = whiteUserId;
        this.blackUserName = blackUserName;
        this.whiteUserName = whiteUserName;
        this.status = status;
        this.boardSize = boardSize;
    }

    public GameBoard toEntity(){
        return GameBoard.builder()
                .blackUserId(blackUserId)
                .whiteUserId(whiteUserId)
                .blackUserName(blackUserName)
                .whiteUserName(whiteUserName)
                .status(Status.STARTED)
                .boardsize(boardSize)
                .build();
    }

}
