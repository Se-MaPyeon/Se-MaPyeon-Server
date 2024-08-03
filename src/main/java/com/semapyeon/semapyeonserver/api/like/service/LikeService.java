package com.semapyeon.semapyeonserver.api.like.service;

import com.semapyeon.semapyeonserver.db.board.entity.Board;
import com.semapyeon.semapyeonserver.db.board.repository.BoardRepository;
import com.semapyeon.semapyeonserver.db.like.entity.Likes;
import com.semapyeon.semapyeonserver.db.like.repository.LikeRepository;
import com.semapyeon.semapyeonserver.db.member.entity.Member;
import com.semapyeon.semapyeonserver.db.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public void createLike(Long memberId, Long boardId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                RuntimeException::new
        );
        Board board = boardRepository.findById(boardId).orElseThrow(
                RuntimeException::new
        );
        Likes likesBoard = Likes.builder().member(member).board(board).build();
        likeRepository.save(likesBoard); //저장
        board.addLikes(); //추천 수 증가
    }

    @Transactional
    public void deleteLike(Long memberId, Long boardId) {
        likeRepository.deleteByMemberIdAndBoardId(memberId, boardId);
    }
}
