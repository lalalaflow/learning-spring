package dev.helloworld.springmvc.login.web.session;

import dev.helloworld.springmvc.login.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {

        // 세션생성 (서버에서 클라이언트로 내려 준 상황)
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member, response);

        // 요청에 응답 쿠키 저장 (클라이언트에서 서버로 쿠키 올려준 상황)
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        // 세션 조회 (클라이언트에서 올려준 쿠키 값 조회 및 확인)
        Object result = sessionManager.getSession(request);
        assertEquals(result, member);

        // 세션 만료
        sessionManager.expire(request);
        assertNull(sessionManager.getSession(request));

    }

}