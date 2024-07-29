package com.semapyeon.semapyeonserver.db.board.entity;

import com.semapyeon.semapyeonserver.db.BaseTimeEntity;
import com.semapyeon.semapyeonserver.db.member.entity.Member;
import com.semapyeon.semapyeonserver.enums.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    String content;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, columnDefinition = "TEXT")
    Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @ColumnDefault("0")
    Integer likes = 0;

    @Builder
    public Board(String title, String content, Category category, Member member) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.member = member;
    }
}
