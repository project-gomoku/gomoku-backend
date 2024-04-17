package com.gomoku.game.service.gameservice.progress;

import com.gomoku.common.enumeration.Status;
import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.domain.winnercheck.RenzuWinnerChecker;
import com.gomoku.game.domain.winnercheck.WinnerChecker;
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
    private WinnerChecker winnerChecker;

    @Override
    @Transactional
    public void load(long id){
        GameBoard gameBoard = gameBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게임 ID 검색 오류"));
        List<PlacementSequence> placementSequences = gameBoard.getPlacementSequence();

        winnerChecker = new RenzuWinnerChecker(gameBoard.getBoardSize());
        winnerChecker.load(placementSequences);
    }

    @Override
    @Transactional
    public long place(long id, PlacementDto dto){
        GameBoard gameBoard = gameBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게임 ID 검색 오류"));

        gameBoard.getPlacementSequence().add(dto.toEntity());

        return id;
    }

    @Override
    @Transactional
    public Status winnerCheck(long id){
        GameBoard gameBoard = gameBoardRepository.findById(id)
                .orElseThrow();
        Stone lastPlacedStone = Stone.NONE;

        if (gameBoard.getStatus() == Status.BLACK_TURN_IN_PROGRESS.getStatus()) {
            lastPlacedStone = Stone.BLACK;
            if (winnerChecker.isWinnerExists(lastPlacedStone)) {
                return Status.BLACK_WIN_NORMAL;
            }
            return Status.WHITE_TURN_IN_PROGRESS;
        }
        else if (gameBoard.getStatus() == Status.WHITE_TURN_IN_PROGRESS.getStatus()) {
            lastPlacedStone = Stone.WHITE;
            if (winnerChecker.isWinnerExists(lastPlacedStone)) {
                return Status.WHITE_WIN_NORMAL;
            }
            return Status.BLACK_TURN_IN_PROGRESS;
        }

        return Status.INTERRUPTED;
    }
}
