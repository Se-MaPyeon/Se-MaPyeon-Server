package com.semapyeon.semapyeonserver.api.member.controller;

import com.semapyeon.semapyeonserver.api.board.dto.response.BoardsResponse;
import com.semapyeon.semapyeonserver.api.board.service.BoardService;
import com.semapyeon.semapyeonserver.api.common.APISuccessResponse;
import com.semapyeon.semapyeonserver.api.common.SuccessMessage;
import com.semapyeon.semapyeonserver.api.member.dto.request.LoginRequest;
import com.semapyeon.semapyeonserver.api.member.service.MemberService;
import com.semapyeon.semapyeonserver.common.auth.PrincipalHandler;
import com.semapyeon.semapyeonserver.common.jwt.TokenResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    private final PrincipalHandler principalHandler;
    private final BoardService boardService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        TokenResponse tokenResponse = memberService.loginMember(loginRequest); //전공, 이름, 학번을 담음(프론트가 필요할 정보들)

        //쿠키 설정 필요
        return ResponseEntity.created(URI.create("/api/v1/board"))
                .body(tokenResponse);

    }

    @GetMapping("/member/boards")
    public ResponseEntity<APISuccessResponse<BoardsResponse>> getMyPage() {
        Long memberId = principalHandler.getMemberIdFromPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(APISuccessResponse.of(SuccessMessage.GET_MY_BOARDS_SUCCESS.getMessage(), SuccessMessage.GET_MY_BOARDS_SUCCESS.getStatus(), boardService.getMyBoards(memberId)));
    }
}
