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
    public GameBoardDto(GameBoard entity){
        this.id = entity.getId();
        this.blackUserId = entity.getBlackUserId();
        this.whiteUserId = entity.getWhiteUserId();
        this.blackUserName = entity.getBlackUserName();
        this.whiteUserName = entity.getWhiteUserName();
        this.status = entity.getStatus();
        this.placementSequence = entity.getPlacementSequence();
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
