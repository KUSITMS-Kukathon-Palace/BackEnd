package com.palace.backend.domain.place.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.palace.backend.domain.equipment.entity.Equipment;
import com.palace.backend.domain.reserve.entity.Reserve;
import com.palace.backend.global.config.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "place")
@Entity
public class Place extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long placeId;

    @Column(length = 10, nullable = false)
    private String category;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String school;

    @Column(nullable = false)
    private long max;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column(nullable = false)
    private long price;

    @Column(length = 100, nullable = false)
    private String place;

    @Column(length = 10, nullable = false)
    private String managerName;

    @Column(length = 20, nullable = false)
    private String managerPhone;

    @Column(length = 100, nullable = false)
    private String accessWay;

    @OneToOne(mappedBy = "place")
    private Reserve reserve;

    @OneToMany(mappedBy = "place")
    @JsonBackReference
    private List<Equipment> equipments = new ArrayList<>();
}
