package com.semapyeon.semapyeonserver.config;

import com.semapyeon.semapyeonserver.member.dao.MemberRepository;
import com.semapyeon.semapyeonserver.member.service.MemberService;
import com.semapyeon.semapyeonserver.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AppConfig {

    private final MemberRepository memberRepository;

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository);

    }
}
