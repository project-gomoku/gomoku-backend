package com.gomoku.game.repo;

import com.gomoku.common.enumeration.Status;
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
public class GameBoardRepositoryTest {

    @Autowired
    GameBoardRepository gameBoardRepository;

    @AfterEach
    public void cleanup(){
        gameBoardRepository.deleteAll();
    }

    @Test
    @DisplayName("게임 보드 초기화 테스트")
    @Transactional
    public void gameBoardInitializeTest(){
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
                .placementSequence(placementSequence)
                .build());

        // when
        List<GameBoard> boardList = gameBoardRepository.findAll();

        // then
        GameBoard board = boardList.get(0);
        assertThat(board.getId()).isEqualTo(1);
        assertThat(board.getBlackUserId()).isEqualTo(12345);
        assertThat(board.getWhiteUserId()).isEqualTo(67890);
        assertThat(board.getBlackUserName()).isEqualTo("abc");
        assertThat(board.getWhiteUserName()).isEqualTo("def");
        assertThat(board.getStatus()).isEqualTo(1);
        assertThat(board.getPlacementSequence().size()).isEqualTo(0);

    }

}
