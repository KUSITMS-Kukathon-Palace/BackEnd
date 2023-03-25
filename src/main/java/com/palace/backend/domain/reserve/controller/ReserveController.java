package com.palace.backend.domain.reserve.controller;

import com.palace.backend.domain.reserve.dto.req.ReqReserveDto;
import com.palace.backend.domain.reserve.dto.resp.RespGetReserveDto;
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

    @GetMapping("/reserve")
    public CommonResponse<RespGetReserveDto> getReserve() {

        RespGetReserveDto respGetReserveDto =  reserveService.getReserve();

        return new CommonResponse<>(respGetReserveDto);
    }
}
