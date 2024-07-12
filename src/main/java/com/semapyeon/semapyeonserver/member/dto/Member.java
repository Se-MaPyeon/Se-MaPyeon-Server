package com.semapyeon.semapyeonserver.member.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String major;
    private String name;
    private String studentId;
    private String pw;

    public Member(String major, String name, String studentId, String pw) {
        this.major = major;
        this.name = name;
        this.studentId = studentId;
        this.pw = pw;
    }
}
