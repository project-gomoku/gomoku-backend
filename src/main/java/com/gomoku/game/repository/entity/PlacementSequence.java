package com.gomoku.game.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.Builder;
import lombok.Getter;

@Embeddable
@Getter
//@Entity
public class PlacementSequence {

    //@Column(name = "GAMEBOARD_ID", insertable = false, updatable = false)
//    private long id;

    private String stoneColor;
    private int height;
    private int width;

    @Builder
    public PlacementSequence(String color, int height, int width){
        this.stoneColor = color;
        this.height = height;
        this.width = width;
    }

}
