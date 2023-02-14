package com.qindel.prices.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PricesDTO {


    private Long productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private String currency;
}
