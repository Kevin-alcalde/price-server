package com.gft.inditext.pricing_server.infrastructure.repository;

import com.gft.inditext.pricing_server.application.model.JpaProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaProductPriceRepository extends JpaRepository<JpaProductPrice, Long> {

    @Query("SELECT pp FROM JpaProductPrice pp " +
            "WHERE pp.brandId = ?1 " +
            "AND pp.productId = ?2 " +
            "AND ?3 BETWEEN pp.startDate AND pp.endDate " +
            "ORDER BY pp.priority DESC " +
            "LIMIT 1")
    Optional<JpaProductPrice> getProductPrice(Long brandId, Integer productId, LocalDateTime requestedDate);

}
