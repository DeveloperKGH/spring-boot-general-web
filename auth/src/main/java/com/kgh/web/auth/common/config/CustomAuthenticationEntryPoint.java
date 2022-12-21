package com.kgh.web.auth.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgh.web.global.common.dto.BaseResponse;
import com.kgh.web.global.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        sendResponse(response, new UnauthorizedException(UnauthorizedException.CauseCode.INVALID_TOKEN));
    }

    private void sendResponse(HttpServletResponse response, UnauthorizedException exception) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(BaseResponse.errorResponse(exception.code, exception.message, exception.errorResults)));
    }
}