package com.gomoku.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Stone {

    BLACK(1, "black"),
    WHITE(2, "white"),
    NONE(0, "none");

    private final int integerColor;
    private final String stringColor;

    public boolean isEqualTo(Stone s){
        return this.integerColor == s.integerColor;
    }

    public static Stone toStone(String color){
        if (color.equals("black")){
            return Stone.BLACK;
        }
        else if (color.equals("white")){
            return Stone.WHITE;
        }
        return Stone.NONE;
    }

}
