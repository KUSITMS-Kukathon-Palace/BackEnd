package com.palace.backend.domain.equipment.Repository;

import com.palace.backend.domain.equipment.entity.Equipment;
import com.palace.backend.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query(value = "select e.place_id from equipment e where e.name = :name", nativeQuery = true)
    Long findPlaceId(@Param("name") String name);
}
