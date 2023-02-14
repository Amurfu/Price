package com.qindel.prices.exception;

import java.time.LocalDateTime;
import java.util.Date;

public class PrecioNotFoundException extends RuntimeException {

    public PrecioNotFoundException(Long productId, Long brandId, LocalDateTime fecha) {
        super(String.format("No se encontró precio para el producto %d, cadena %d y fecha %s", productId, brandId, fecha));
    }
}
