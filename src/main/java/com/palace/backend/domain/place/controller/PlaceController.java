package com.palace.backend.domain.place.controller;

import com.palace.backend.domain.place.dto.PlaceAllRes;
import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/place/all")
    public ResponseEntity<List<PlaceAllRes>> getPlace() {

        List<Place> findPlaces = placeService.getPlaceAll();

        List<PlaceAllRes> res = findPlaces.stream()
                .map(m -> new PlaceAllRes(m.getName(), m.getPlace(), m.getCategory(), m.getMax()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
