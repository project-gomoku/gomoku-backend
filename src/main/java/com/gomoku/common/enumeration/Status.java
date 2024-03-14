package com.gomoku.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    STARTED(1),
    BLACK_TURN_IN_PROGRESS(2),
    WHITE_TURN_IN_PROGRESS(3),
    BLACK_WIN_NORMAL(4),
    WHITE_WIN_NORMAL(5),
    BLACK_WIN_TIME(6),
    WHITE_WIN_TIME(7),
    BLACK_WIN_RESIGN(8),
    WHITE_WIN_RESIGN(9),
    INTERRUPTED(0);

    private final int status;

}
