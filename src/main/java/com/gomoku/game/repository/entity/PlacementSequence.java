package com.gomoku.game.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
//@Entity
public class PlacementSequence {

    @Column(name = "GAMEBOARD_ID", insertable = false, updatable = false)
    private long gameBoardId;
    private String stoneColor;
    private int height;
    private int width;

}
