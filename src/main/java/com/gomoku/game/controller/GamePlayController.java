package com.gomoku.game.controller;

import com.gomoku.game.dto.GameBoardInitializeDto;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class GamePlayController {

    private final GameService gameService;

    @PostMapping("play/{id}")
    public GameBoard initialize(@RequestBody GameBoardInitializeDto initializeDto){
        return gameService.initialize(initializeDto);
    }

}
