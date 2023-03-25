package com.palace.backend.domain.place.repository;

import com.palace.backend.domain.place.dto.ResPlaceDetailDto;
import com.palace.backend.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query(value = "select * from place p", nativeQuery = true)
    List<Place> findPlaceAll();

    @Query(value = "select * from place p where p.name = :name", nativeQuery = true)
    List<Place> findPlaceDetail(@Param("name") String name);

    @Query(value = "select p.place_id from place p where p.name = :name", nativeQuery = true)
    Long findPlaceId(@Param("name") String name);


}
