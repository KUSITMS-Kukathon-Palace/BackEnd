package com.palace.backend.domain.place.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceAllRes {

    private String placeName;
    private String location;
    private String category;
    private long max;


}
