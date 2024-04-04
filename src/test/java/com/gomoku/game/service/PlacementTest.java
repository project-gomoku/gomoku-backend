package com.gomoku.game.service;

import com.gomoku.common.enumeration.Status;
import com.gomoku.game.dto.PlacementDto;
import com.gomoku.game.repository.GameBoardRepository;
import com.gomoku.game.repository.entity.GameBoard;
import com.gomoku.game.repository.entity.PlacementSequence;
import com.gomoku.game.service.gameservice.progress.GameProgressService;
import com.gomoku.game.service.gameservice.progress.GameProgressServiceImpl;
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
public class PlacementTest {

    @Autowired
    GameBoardRepository gameBoardRepository;

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
        GameProgressService service = new GameProgressServiceImpl(gameBoardRepository);
        service.place(1,
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

}
