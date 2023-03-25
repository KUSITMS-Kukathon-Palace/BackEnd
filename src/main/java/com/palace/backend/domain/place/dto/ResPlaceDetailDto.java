package com.palace.backend.domain.place.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResPlaceDetailDto {

    private String placeName; // 장소 이름
    private String school; // 학교 이름
    private String location; // 위치
    private long max; // 수용 인원
    private String category; // 공간 카테고리
    private String managerName; // 담당자 이름
}
