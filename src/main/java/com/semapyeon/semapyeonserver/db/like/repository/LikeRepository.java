package com.semapyeon.semapyeonserver.db.like.repository;

import com.semapyeon.semapyeonserver.db.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
