package com.semapyeon.semapyeonserver.common.auth;

import org.springframework.security.core.context.SecurityContextHolder;

public class PrincipalHandler {

    private static final String ANONYMOUS_MEMBER = "anonymousMember";

    public Long getMemberIdFromPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        isPrincipalNull(principal);
        return Long.valueOf(principal.toString());
    }

    public void isPrincipalNull(
            final Object principal
    ) {
        if (principal.toString().equals(ANONYMOUS_MEMBER)) {
            throw new RuntimeException("error");
        }
    }
}
