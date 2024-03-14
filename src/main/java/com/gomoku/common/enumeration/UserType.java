package com.gomoku.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserType {
    GUEST(0),
    NORMAL(1);
    
    private final int type;
}
