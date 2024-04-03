package com.gomoku.game.service.gameservice.progress;

import com.gomoku.game.domain.board.Board;
import com.gomoku.game.domain.board.BoardImpl;
import com.gomoku.game.dto.PlacementDto;
import com.gomoku.game.repository.GameBoardRepository;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.repository.entity.PlacementSequence;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameProgressServiceImpl implements GameProgressService {

    private final GameBoardRepository gameBoardRepository;
    private Board board;

    @Override
    @Transactional
    public void load(long id){
        GameBoard gameBoard = gameBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게임 ID 검색 오류"));
        List<PlacementSequence> placementSequences = gameBoard.getPlacementSequence();

        board = new BoardImpl(gameBoard.getBoardSize());
        board.load(placementSequences);
    }

    @Override
    @Transactional
    public long place(long id, PlacementDto dto){
        GameBoard gameBoard = gameBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게임 ID 검색 오류"));

        gameBoard.getPlacementSequence().add(dto.toEntity());

        return id;
    }
}
