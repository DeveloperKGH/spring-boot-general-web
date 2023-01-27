package com.kgh.web.member.interfaces.controller;

import com.kgh.web.global.common.controller.BaseController;
import com.kgh.web.global.common.dto.BaseResponse;
import com.kgh.web.member.interfaces.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController extends BaseController {

    @GetMapping("/me")
    public BaseResponse<MemberResponse> getMyInfo() {
        MemberResponse response = MemberResponse
                .builder()
                .id(1L)
                .loginId("me sample")
                .build();
        return BaseResponse.successResponse(response);
    }

    @GetMapping("/members/{id}")
    public BaseResponse<MemberResponse> getMemberInfo(@PathVariable Long id) {
        MemberResponse response = MemberResponse
                .builder()
                .id(1L)
                .loginId("member sample")
                .build();
        return BaseResponse.successResponse(response);
    }

}

