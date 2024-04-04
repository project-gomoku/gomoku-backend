package com.gomoku.game.service.gameservice.initializement;

import com.gomoku.game.dto.GameBoardInitializeDto;
import com.gomoku.game.dto.PlacementDto;
import com.gomoku.game.repository.GameBoardRepository;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.repository.entity.PlacementSequence;
import com.gomoku.game.domain.board.Board;
import com.gomoku.game.service.gameservice.progress.GameProgressService;
import com.gomoku.game.service.gameservice.progress.GameProgressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameInitializeServiceImpl implements GameInitializeService {

    private final GameBoardRepository gameBoardRepository;

    @Override
    @Transactional
    public GameBoard initialize(GameBoardInitializeDto gameBoardDto) {
        return gameBoardRepository.save(gameBoardDto.toEntity());
    }



}
