/*
package com.jiyunieo.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Configuration
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //String errorMessage = null;

        if (exception instanceof BadCredentialsException) {
            System.out.println("아이디와 비밀번호를 확인해주세요.");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            System.out.println("내부 시스템 문제로 로그인할 수 없습니다. 관리자에게 문의하세요.");

        } else if (exception instanceof UsernameNotFoundException) {
            System.out.println("존재하지 않는 계정입니다.");
        } else {
            System.out.println("알 수없는 오류입니다.");
        }

        super.onAuthenticationFailure(request, response, exception);
    }
}
*/
