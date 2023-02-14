package com.qindel.prices.repository;

import com.qindel.prices.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface PricesRepository extends JpaRepository<Prices,Integer> {

    @Query(value = "SELECT TOP(1)* FROM Prices p " +
            "WHERE p.PRODUCT_ID = :productoId " +
            "AND p.BRAND_ID = :brandId " +
            "AND :fecha BETWEEN p.START_DATE AND p.END_DATE " +
            "ORDER BY p.priority DESC",nativeQuery = true)
    Prices findByData(@Param("productoId") Long productoId,
                                       @Param("brandId")Long brandId,
                                       @Param("fecha") LocalDateTime fecha);
}
