package com.semapyeon.semapyeonserver.member.dao;

import com.semapyeon.semapyeonserver.member.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByStudentId(String studentId);
}
