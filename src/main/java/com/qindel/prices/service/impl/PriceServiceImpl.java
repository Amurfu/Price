package com.qindel.prices.service.impl;

import com.qindel.prices.exception.PrecioNotFoundException;
import com.qindel.prices.model.Prices;
import com.qindel.prices.model.dto.PricesDTO;
import com.qindel.prices.repository.PricesRepository;
import com.qindel.prices.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PricesRepository pricesRepository;


    @Override
    public PricesDTO obtenerPrecio(LocalDateTime fecha, Long productId, Long cadenaId) {
        Prices pricesList = pricesRepository.findByData(productId,cadenaId,fecha);
        if(pricesList == null)
            throw new PrecioNotFoundException(productId,cadenaId,fecha);
        else
            return mapToDto(pricesList);
    }

    private PricesDTO mapToDto(Prices prices) {
        PricesDTO pricesDTO = new PricesDTO();
        pricesDTO.setPrice(prices.getPrice());
        pricesDTO.setPriceList(prices.getPriceList());
        pricesDTO.setCurrency(prices.getCurrency());
        pricesDTO.setBrandId(prices.getBrandId());
        pricesDTO.setEndDate(prices.getEndDate());
        pricesDTO.setProductId(prices.getProductId());
        pricesDTO.setStartDate(prices.getStartDate());
        return pricesDTO;
    }
}
