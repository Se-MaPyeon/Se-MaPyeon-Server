package com.semapyeon.semapyeonserver.db.member.entity;

import com.semapyeon.semapyeonserver.db.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String pw;

    public Member(String major, String name, String studentId, String pw) {
        this.major = major;
        this.name = name;
        this.studentId = studentId;
        this.pw = pw;
    }
}
