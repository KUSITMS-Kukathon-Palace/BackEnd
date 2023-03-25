package com.palace.backend.domain.place.service;

import com.palace.backend.domain.equipment.Repository.EquipmentRepository;
import com.palace.backend.domain.place.dto.ReqPlaceDetailDto;
import com.palace.backend.domain.place.dto.ResPlaceDetailDto;
import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.domain.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final EquipmentRepository equipmentRepository;

    public List<Place> getPlaceAll() {
        return placeRepository.findPlaceAll();
    }

    public List<Place> getPlaceDetail(String name) {
        return placeRepository.findPlaceDetail(name);
    }

    public Long getPlaceId(String name) {
        return placeRepository.findPlaceId(name);
    }

    public Place getPlace(Long id) {
        return placeRepository.findPlace(id);
    }

}
