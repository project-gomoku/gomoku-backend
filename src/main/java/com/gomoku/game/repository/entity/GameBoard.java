package com.gomoku.game.repository.entity;

import com.gomoku.common.entity.BaseTimeEntity;
import com.gomoku.common.enumeration.Status;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class GameBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAMEBOARD_ID")
    private long Id;

    @Column(nullable = false)
    private long blackUserId;

    @Column(nullable = false)
    private long whiteUserId;

    @Column(nullable = false)
    private String blackUserName;

    @Column(nullable = false)
    private String whiteUserName;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private int boardSize;

    @Column
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "PLACEMENT_SEQUENCE", joinColumns = @JoinColumn(name="GAMEBOARD_ID", referencedColumnName = "GAMEBOARD_ID"))
    private List<PlacementSequence> placementSequence = new ArrayList<>();

    @Builder
    GameBoard(long blackUserId, long whiteUserId, String blackUserName, String whiteUserName, Status status,
              int boardsize)
    {
        this.blackUserId = blackUserId;
        this.whiteUserId = whiteUserId;
        this.blackUserName = blackUserName;
        this.whiteUserName = whiteUserName;
        this.status = status.getStatus();
        this.boardSize = boardsize;
    }

}
