package com.palace.backend.domain.reserve.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqReserveDto {

    @NotNull(message = "reserveStart는 비어있을 수 없습니다.")
    private LocalDateTime reserveStart;

    @NotNull(message = "reserveEnd는 비어있을 수 없습니다.")
    private LocalDateTime reserveEnd;

    @NotNull(message = "people은 비어있을 수 없습니다.")
    private Long people;

    @NotBlank(message = "nickname 은 비어있을 수 없습니다.")
    @Size(min = 1, max = 4, message="nickname 은 최소 1개, 최대 7개의 문자만 입력 가능합니다.")
    private String nickname;

    @NotBlank(message = "phoneNumber은 비어있을 수 없습니다.")
    private String phoneNumber;

    @NotBlank(message = "groupName은 비어있을 수 없습니다.")
    private String groupName;

    @NotBlank(message = "purpose는 비어있을 수 없습니다.")
    private String purpose;

    @NotBlank(message = "request는 비어있을 수 없습니다.")
    private String request;

}
