package com.palace.backend.domain.reserve.repository;

import com.palace.backend.domain.reserve.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
