package com.qindel.prices.service;

import com.qindel.prices.model.dto.PricesDTO;

import java.time.LocalDateTime;
import java.util.Date;

public interface PriceService {

   public PricesDTO obtenerPrecio(LocalDateTime fecha, Long productId, Long cadenaId);
}
