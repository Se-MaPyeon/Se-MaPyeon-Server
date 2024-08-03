package com.semapyeon.semapyeonserver.db.like.repository;

import com.semapyeon.semapyeonserver.db.like.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    void deleteAllByBoardId(Long boardId);

    void deleteByMemberIdAndBoardId(Long memberId, Long boardId);
}
