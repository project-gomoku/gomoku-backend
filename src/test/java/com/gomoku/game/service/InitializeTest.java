package com.gomoku.game.service;

import com.gomoku.common.enumeration.Status;
import com.gomoku.game.dto.GameBoardInitializeDto;
import com.gomoku.game.repository.GameBoardRepository;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.repository.entity.PlacementSequence;
import com.gomoku.game.service.gameservice.initializement.GameInitializeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InitializeTest {

    @Autowired
    private GameBoardRepository gameBoardRepository;
    @Autowired
    private GameInitializeService gameInitializeService;

    @AfterEach
    public void cleanup(){
        gameBoardRepository.deleteAll();
    }

    @Test
    @DisplayName("게임보드 초기화 테스트")
    @Transactional
    public void initializeServiceTest(){
        // given
        long blackUserId = 12345;
        long whiteUserId = 67890;
        String blackUserName = "abc";
        String whiteUserName = "def";
        Status status = Status.STARTED;
        int boardSize = 15;

        // when
        gameInitializeService.initialize(GameBoardInitializeDto.builder()
                .blackUserId(blackUserId)
                .whiteUserId(whiteUserId)
                .blackUserName(blackUserName)
                .whiteUserName(whiteUserName)
                .status(status.getStatus())
                .boardSize(boardSize)
                .build());

        // then
        GameBoard gameBoard = gameBoardRepository.findById(1L)
                .orElseThrow();

        assertThat(gameBoard.getId()).isEqualTo(1L);
        assertThat(gameBoard.getBlackUserId()).isEqualTo(blackUserId);
        assertThat(gameBoard.getWhiteUserId()).isEqualTo(whiteUserId);
        assertThat(gameBoard.getBlackUserName()).isEqualTo(blackUserName);
        assertThat(gameBoard.getWhiteUserName()).isEqualTo(whiteUserName);
        assertThat(gameBoard.getBoardSize()).isEqualTo(boardSize);
    }

}
