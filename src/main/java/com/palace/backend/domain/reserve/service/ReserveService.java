package com.palace.backend.domain.reserve.service;

import com.palace.backend.domain.reserve.dto.ReqReserveDto;
import com.palace.backend.domain.reserve.entity.Reserve;
import com.palace.backend.domain.reserve.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReserveService {

    private final ReserveRepository reserveRepository;

    public void reservePlace(ReqReserveDto reqReserveDto) {

        Reserve reserve = Reserve.createReserve(reqReserveDto);

        reserveRepository.save(reserve);
    }

}
