package com.gomoku.game.service;

import com.gomoku.game.dto.GameBoardDto;
import com.gomoku.game.repository.GameBoardRepository;
import com.gomoku.game.repository.entity.GameBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GameServiceImpl implements GameService{

    private final GameBoardRepository gameBoardRepository;

    @Override
    @Transactional
    public GameBoard initialize(GameBoardDto gameBoardDto) {
        return gameBoardRepository.save(gameBoardDto.toEntity());
    }
}
