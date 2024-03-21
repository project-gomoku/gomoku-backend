package com.gomoku.common.entity;

import com.gomoku.common.enumeration.UserType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class GameUser extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 10, nullable = false)
    private String gameId;

    @Column(nullable = false)
    private int userType;

    @Builder
    public GameUser(String gameId, UserType userType){
        this.gameId = gameId;
        this.userType = userType.getType();
    }

}
