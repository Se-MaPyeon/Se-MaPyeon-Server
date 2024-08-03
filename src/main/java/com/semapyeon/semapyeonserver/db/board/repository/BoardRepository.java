package com.semapyeon.semapyeonserver.db.board.repository;

import com.semapyeon.semapyeonserver.db.board.entity.Board;
import com.semapyeon.semapyeonserver.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByCategory(Category category);

    List<Board> findAllByMemberId(Long memberId);
}
