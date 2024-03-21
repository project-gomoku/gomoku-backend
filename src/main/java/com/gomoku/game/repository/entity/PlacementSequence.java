package com.gomoku.game.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PlacementSequence {

    @Column(name = "board_id", insertable = false, updatable = false)
    private long gameBoardId;
    private String stoneColor;
    private int height;
    private int width;

}
