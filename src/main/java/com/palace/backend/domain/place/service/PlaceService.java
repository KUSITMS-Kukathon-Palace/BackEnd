package com.palace.backend.domain.place.service;

import com.palace.backend.domain.place.dto.PlaceAllRes;
import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.domain.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> getPlaceAll() {
        return placeRepository.findPlaceAll();
    }
}
