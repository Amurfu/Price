package com.qindel.prices.controller;

import com.qindel.prices.model.dto.PricesDTO;
import com.qindel.prices.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public PricesDTO obtenerPrecio(@RequestParam(name ="fecha", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
                                   @RequestParam(name="productId",required = true) Long productId,
                                   @RequestParam(name = "brandId",required = true) Long brandId){
        return priceService.obtenerPrecio(fecha,productId,brandId);
    }
}
