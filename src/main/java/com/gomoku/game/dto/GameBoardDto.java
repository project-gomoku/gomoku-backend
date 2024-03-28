package com.gomoku.game.dto;

import com.gomoku.common.enumeration.Status;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.repository.entity.PlacementSequence;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class GameBoardDto {

    private long id;
    private long blackUserId;
    private long whiteUserId;
    private String blackUserName;
    private String whiteUserName;
    private int status;
    private List<PlacementSequence> placementSequence;

    @Builder
    public GameBoardDto(long blackUserId, long whiteUserId, String blackUserName, String whiteUserName, int status,
                        List<PlacementSequence> placementSequence)
    {
        this.blackUserId = blackUserId;
        this.whiteUserId = whiteUserId;
        this.blackUserName = blackUserName;
        this.whiteUserName = whiteUserName;
        this.status = status;
        this.placementSequence = placementSequence;
    }

    public GameBoard toEntity(){
        return GameBoard.builder()
                .blackUserId(blackUserId)
                .whiteUserId(whiteUserId)
                .blackUserName(blackUserName)
                .whiteUserName(whiteUserName)
                .status(Status.STARTED)
                .placementSequence(placementSequence)
                .build();
    }

}
