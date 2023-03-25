package com.palace.backend.domain.equipment.controller;

import com.palace.backend.domain.equipment.service.EquipmentService;
import com.palace.backend.domain.place.dto.ResPlaceDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;


}
