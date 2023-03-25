package com.palace.backend.domain.reserve.dto.resp;

import com.palace.backend.domain.reserve.entity.Reserve;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReserveDto {
    private LocalDateTime reserveStart;
    private LocalDateTime reserveEnd;
    private String name;
    private String shool;
    private String place;
    private String group;
    private Long people;

    public static ReserveDto makeReserveDto(Reserve reserve){

        ReserveDto reserveDto = new ReserveDto();
        reserveDto.setReserveStart(reserve.getReserveStart());
        reserveDto.setReserveEnd(reserve.getReserveEnd());
        reserveDto.setName(reserve.getPlace().getName());
        reserveDto.setShool(reserve.getPlace().getSchool());
        reserveDto.setPlace(reserve.getPlace().getPlace());
        reserveDto.setGroup(reserve.getGroupName());
        reserveDto.setPeople(reserve.getReservePeople());

        return reserveDto;
    }
}
