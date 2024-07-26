package com.semapyeon.semapyeonserver.db.member.repository;

import com.semapyeon.semapyeonserver.db.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByStudentId(String studentId);
}