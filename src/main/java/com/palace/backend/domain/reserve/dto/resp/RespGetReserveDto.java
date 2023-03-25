package com.palace.backend.domain.reserve.dto.resp;

import com.palace.backend.domain.reserve.entity.Reserve;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RespGetReserveDto {
    private List<ReserveDto> reserve;

    public static RespGetReserveDto makeRespGetReserveDto(List<Reserve> reserves){
        List<ReserveDto> reserve = new ArrayList<>();
        for(Reserve r : reserves){
            ReserveDto reserveDto = ReserveDto.makeReserveDto(r);

            reserve.add(reserveDto);
        }
        RespGetReserveDto respGetReserveDto = RespGetReserveDto.builder()
                .reserve(reserve)
                .build();

        return respGetReserveDto;

    }
}
