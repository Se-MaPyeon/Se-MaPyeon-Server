package com.semapyeon.semapyeonserver.config;

import com.semapyeon.semapyeonserver.member.service.MemberService;
import com.semapyeon.semapyeonserver.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Config {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl();
    }
}
