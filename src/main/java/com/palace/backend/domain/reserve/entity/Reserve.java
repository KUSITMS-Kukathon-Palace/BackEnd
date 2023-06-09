package com.palace.backend.domain.reserve.entity;

import com.palace.backend.domain.member.entity.Member;
import com.palace.backend.domain.place.entity.Place;
import com.palace.backend.domain.reserve.dto.req.ReqReserveDto;
import com.palace.backend.global.config.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(length = 300)
    private String request;

    private Long approve;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    public static Reserve createReserve(ReqReserveDto reqReserveDto, Place place) {
        Reserve reserve = Reserve.builder()
                .reserveStart(reqReserveDto.getReserveStart())
                .reserveEnd(reqReserveDto.getReserveEnd())
                .reservePeople(reqReserveDto.getPeople())
                .name(reqReserveDto.getNickname())
                .phoneNumber(reqReserveDto.getPhoneNumber())
                .groupName(reqReserveDto.getGroupName())
                .purpose(reqReserveDto.getPurpose())
                .request(reqReserveDto.getRequest())
                .approve(reqReserveDto.getApprove())
                .place(place)
                .build();

        return reserve;
    }
}
