package com.palace.backend.domain.equipment.Repository;

import com.palace.backend.domain.equipment.entity.Equipment;
import com.palace.backend.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {


}
