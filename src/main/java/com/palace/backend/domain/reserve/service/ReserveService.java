package com.palace.backend.domain.reserve.service;

import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.domain.place.repository.PlaceRepository;
import com.palace.backend.domain.reserve.dto.req.ReqReserveDto;
import com.palace.backend.domain.reserve.dto.resp.RespGetReserveDto;
import com.palace.backend.domain.reserve.entity.Reserve;
import com.palace.backend.domain.reserve.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final PlaceRepository placeRepository;

    public void reservePlace(ReqReserveDto reqReserveDto) {

        Place place = placeRepository.findPlaceIn(reqReserveDto.getPlace());

        Reserve reserve = Reserve.createReserve(reqReserveDto, place);

        System.out.println(reserve.getPlace().getName());
        System.out.println(reserve.getPlace().getSchool());

        reserveRepository.save(reserve);
    }

    public RespGetReserveDto getReserve() {

        List<Reserve> reserves = reserveRepository.findAll();

        RespGetReserveDto respGetReserveDto = RespGetReserveDto.makeRespGetReserveDto(reserves);

        return respGetReserveDto;
    }
}
