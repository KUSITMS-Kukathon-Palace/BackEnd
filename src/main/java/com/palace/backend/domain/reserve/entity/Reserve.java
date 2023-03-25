package com.palace.backend.domain.reserve.entity;

import com.palace.backend.domain.member.entity.Member;
import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.global.config.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "reserve")
@Entity
public class Reserve extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private Long reserveId;

    @Column(nullable = false)
    private LocalDateTime reserveStart;

    @Column(nullable = false)
    private LocalDateTime reserveEnd;

    @Column(nullable = false)
    private Long reservePeople;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 50, nullable = false)
    private String groupName;

    @Column(length = 300, nullable = false)
    private String purpose;

    @Column(length = 300, nullable = false)
    private String request;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
