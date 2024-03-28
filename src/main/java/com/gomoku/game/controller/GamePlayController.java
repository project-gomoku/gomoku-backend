package com.gomoku.game.controller;

import com.gomoku.game.dto.GameBoardDto;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class GamePlayController {

    private final GameService gameService;

    @PostMapping("play/{id}")
    public GameBoard initialize(@RequestBody GameBoardDto initializeDto){
        return gameService.initialize(initializeDto);
    }

}
