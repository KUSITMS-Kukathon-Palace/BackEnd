package com.palace.backend.domain.reserve.controller;

import com.palace.backend.domain.reserve.dto.ReqReserveDto;
import com.palace.backend.domain.reserve.service.ReserveService;
import com.palace.backend.global.response.CommonResponse;
import com.palace.backend.global.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReserveController {

    private final ReserveService reserveService;

    @PostMapping("/reserve")
    public CommonResponse<?> reservePlace(@RequestBody ReqReserveDto reqReserveDto) {

        reserveService.reservePlace(reqReserveDto);

        return new CommonResponse<>(ErrorCode.SUCCESS);
    }
}
