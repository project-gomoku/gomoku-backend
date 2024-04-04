package com.gomoku.game.dto;

import com.gomoku.game.repository.entity.PlacementSequence;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PlacementDto {

    private long id;
    private String color;
    private int height;
    private int width;

    @Builder
    public PlacementDto(long id, String color, int height, int width){
        this.id = id;
        this.color = color;
        this.height = height;
        this.width = width;
    }

    public PlacementSequence toEntity(){
        return PlacementSequence.builder()

                .color(color)
                .height(height)
                .width(width)
                .build();
    }

}
