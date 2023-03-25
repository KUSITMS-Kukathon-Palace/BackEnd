package com.palace.backend.domain.equipment.entity;

import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.domain.reserve.entity.Reserve;
import com.palace.backend.global.config.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "equipment")
@Entity
public class Equipment extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;

    private Boolean internet;
    private Boolean beam;
    private Boolean mike;
    private Boolean board;
    private Boolean multi;
    private Boolean record;
    private Boolean shower;
    private Boolean beverage;
    private Boolean food;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

}
