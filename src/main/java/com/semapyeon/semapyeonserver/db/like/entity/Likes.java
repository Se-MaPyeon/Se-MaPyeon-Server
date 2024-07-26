package com.semapyeon.semapyeonserver.db.like.entity;

import com.semapyeon.semapyeonserver.db.BaseTimeEntity;
import com.semapyeon.semapyeonserver.db.board.entity.Board;
import com.semapyeon.semapyeonserver.db.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Likes extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    public Likes(Member member, Board board) {
        this.member = member;
        this.board = board;
    }
}
