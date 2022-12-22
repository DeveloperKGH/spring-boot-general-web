package com.kgh.web.global.common.controller;

import com.kgh.web.global.error.ErrorResult;
import com.kgh.web.global.error.exception.BadRequestException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/{version}")
public class BaseController {
    public void checkBindings(BindingResult result) {
        if (result.hasErrors()) {
            List<ErrorResult> collect = result.getFieldErrors()
                    .stream()
                    .map(m -> new ErrorResult(m.getField(), m.getDefaultMessage()))
                    .collect(Collectors.toList());
            throw new BadRequestException(collect);
        }
    }
}
