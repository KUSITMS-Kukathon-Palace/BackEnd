package com.palace.backend.domain.place.repository;

import com.palace.backend.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query(value = "select * from place p", nativeQuery = true)
    List<Place> findPlaceAll();

    @Query("select p from Place p where p.name in :place")
    Place findPlaceIn(String place);
}