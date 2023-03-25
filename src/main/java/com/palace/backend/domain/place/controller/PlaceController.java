package com.palace.backend.domain.place.controller;

import com.palace.backend.domain.equipment.entity.Equipment;
import com.palace.backend.domain.place.dto.ResPlaceAllDto;
import com.palace.backend.domain.place.dto.ResPlaceDetailDto;
import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.domain.place.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/place/all")
    public ResponseEntity<List<ResPlaceAllDto>> getPlace() {

        List<Place> findPlaces = placeService.getPlaceAll();

        List<ResPlaceAllDto> res = findPlaces.stream()
                .map(m -> new ResPlaceAllDto(m.getName(), m.getPlace(), m.getCategory(), m.getMax()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value = "/place/detail")
    public ResponseEntity<Result> getPlaceDetail(@RequestParam String name) {

        // req 속 name(placeName) 에 해당하는 place 정보
        List<Place> findPlaces = placeService.getPlaceDetail(name);

        List<ResPlaceDetailDto> detailRes = findPlaces.stream()
                .map(m -> new ResPlaceDetailDto(m.getName(), m.getSchool(), m.getPlace(), m.getMax(), m.getCategory(), m.getManagerName()))
                .collect(Collectors.toList());

        // req 속 name(placeName) 에 해당하는 place_id 를 찾아서, equipment 레코드에서 값이 1인 column list 반환
        Long findPlaceId = placeService.getPlaceId(name);

        // id -> place 객체 -> place 속 equipment 객체 리스트 get
        Place findPlace = placeService.getPlace(findPlaceId);
        List<Equipment> equipments = findPlace.getEquipments();


        return new ResponseEntity<>(new Result(detailRes, findPlaceId, equipments), HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T detail;
        private Long placeId;
        private List<Equipment> equipmentList;
    }

}
