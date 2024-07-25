package com.semapyeon.semapyeonserver.api.board.service;

import com.semapyeon.semapyeonserver.api.board.dto.request.WriteBoardRequest;
import com.semapyeon.semapyeonserver.api.board.dto.response.BoardResponse;
import com.semapyeon.semapyeonserver.api.board.dto.response.BoardsResponse;
import com.semapyeon.semapyeonserver.db.board.entity.Board;
import com.semapyeon.semapyeonserver.db.board.repository.BoardRepository;
import com.semapyeon.semapyeonserver.db.member.repository.MemberRepository;
import com.semapyeon.semapyeonserver.enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardsResponse getBoards(Category category) {
        List<Board> boards;
        if (category.equals(Category.ALL)) {
            boards = boardRepository.findAll();
        } else {
            boards = boardRepository.findAllByCategory(category);
        }

        return BoardsResponse.of(boards.stream()
                .map(board -> BoardResponse.of(board.getId(), board.getTitle(), board.getContent(), board.getCategory().getCategory(), board.getUpdatedAt().toString(), board.getLikes()))
                .toList());
    }

    public BoardsResponse getMyBoards(Long memberId) {
        List<Board> boards = boardRepository.findAllByMemberId(memberId);

        return BoardsResponse.of(boards.stream()
                .map(board -> BoardResponse.of(board.getId(), board.getTitle(), board.getContent(), board.getCategory().getCategory(), board.getUpdatedAt().toString(), board.getLikes()))
                .toList());
    }

    public void writeBoard(Long memberId, WriteBoardRequest writeBoardRequest) {
        boardRepository.save(Board.builder()
                .title(writeBoardRequest.title())
                .content(writeBoardRequest.content())
                .category(writeBoardRequest.category())
                .member(memberRepository.findById(memberId).orElseThrow(
                        () -> new RuntimeException()
                ))
                .build());
    }
}
