package com.kgh.web.member.interfaces.controller;

import com.kgh.web.global.common.controller.BaseController;
import com.kgh.web.global.common.dto.BaseResponse;
import com.kgh.web.member.application.service.SignInService;
import com.kgh.web.member.application.service.SignUpService;
import com.kgh.web.member.interfaces.dto.SignInRequest;
import com.kgh.web.member.interfaces.dto.SignInResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SignInController extends BaseController {

    private final SignInService signInService;

    /**
     * 로그인
     *
     * @param request 로그인 요청 request
     * @param bindingResult request 검증 오류정보 저장
     * @return BaseResponse<SignInResponse> 로그인 완료 response
     */
    @PostMapping("/signin")
    public BaseResponse<SignInResponse> signIn(@RequestBody @Valid SignInRequest request, BindingResult bindingResult) {
        checkBindings(bindingResult);
        return BaseResponse.successResponse(signInService.signIn(request.toServiceDto()));
    }

}

