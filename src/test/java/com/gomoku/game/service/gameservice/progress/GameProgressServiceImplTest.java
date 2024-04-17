package com.gomoku.game.service.gameservice.progress;

import com.gomoku.common.enumeration.Status;
import com.gomoku.common.enumeration.Stone;
import com.gomoku.game.dto.PlacementDto;
import com.gomoku.game.repository.GameBoardRepository;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.repository.entity.PlacementSequence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameProgressServiceImplTest {
    @Autowired
    GameBoardRepository gameBoardRepository;
    @Autowired
    GameProgressServiceImpl gameProgressService;

    @AfterEach
    public void cleanup(){
        gameBoardRepository.deleteAll();
    }

    @Test
    @DisplayName("착수 업데이트 테스트")
    @Transactional
    public void placementTest(){
        // given
        long blackUserId = 12345;
        long whiteUserId = 67890;
        String blackUserName = "abc";
        String whiteUserName = "def";
        Status status = Status.STARTED;
        List<PlacementSequence> placementSequence = new ArrayList<>();

        gameBoardRepository.save(GameBoard.builder()
                .blackUserId(blackUserId)
                .whiteUserId(whiteUserId)
                .blackUserName(blackUserName)
                .whiteUserName(whiteUserName)
                .status(status)
                .build());

        // when
        gameProgressService.place(1,
                PlacementDto.builder()
                        .color("black")
                        .width(1)
                        .height(1)
                        .build());

        // then
        GameBoard gameBoard = gameBoardRepository.findById(1L)
                .orElseThrow();

        PlacementSequence placement = gameBoard.getPlacementSequence().get(0);
        assertThat(placement.getStoneColor()).isEqualTo("black");
        assertThat(placement.getHeight()).isEqualTo(1);
        assertThat(placement.getWidth()).isEqualTo(1);

    }

    @Test
    @DisplayName("승자 체크 로직 테스트")
    @Transactional
    public void winnerCheckTest(){
        // given
        long blackUserId = 12345;
        long whiteUserId = 67890;
        String blackUserName = "abc";
        String whiteUserName = "def";
        Status status = Status.BLACK_TURN_IN_PROGRESS;

        gameBoardRepository.save(GameBoard.builder()
                .blackUserId(blackUserId)
                .whiteUserId(whiteUserId)
                .blackUserName(blackUserName)
                .whiteUserName(whiteUserName)
                .boardsize(15)
                .status(status)
                .build());

        for (int i = 0; i < 4; i++){
            gameProgressService.place(1L,
                    PlacementDto.builder()
                    .color("black")
                    .height(7+i)
                    .width(7)
                    .build());
            gameProgressService.place(1L,
                    PlacementDto.builder()
                    .color("white")
                    .height(i+1)
                    .width(i)
                    .build());
        }
        gameProgressService.place(1L,
                PlacementDto.builder()
                .color("black")
                .height(11)
                .width(7)
                .build());

        // when
        gameProgressService.load(1L);
        Status lodedStatus = gameProgressService.winnerCheck(1L);

        // then
        assertThat(lodedStatus).isEqualTo(Status.BLACK_WIN_NORMAL);
    }
}