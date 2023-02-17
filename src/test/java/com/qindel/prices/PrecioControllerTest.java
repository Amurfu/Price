package com.qindel.prices;


import com.qindel.prices.exception.PrecioNotFoundException;
import com.qindel.prices.model.Prices;
import com.qindel.prices.model.dto.PricesDTO;
import com.qindel.prices.repository.PricesRepository;
import com.qindel.prices.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class PrecioControllerTest {

    @Mock
    PricesRepository pricesRepository;

    @InjectMocks
    private PriceServiceImpl priceService;



    @Test
    public void testBuscarPrice() throws Exception {
        Prices esperado = cartgarDomi1();
        PricesDTO esperadoDto = cartgarDomiDto1();
        Mockito.when(pricesRepository.findByData(Mockito.anyLong(),Mockito.anyLong(),Mockito.any())).
                thenReturn(esperado);
        PricesDTO result = priceService.obtenerPrecio(converLocalDate("2020-06-15 00:00:00"),35455L,1l);
        Assertions.assertEquals(esperadoDto,result);
        Mockito.verify(pricesRepository).findByData(Mockito.anyLong(),Mockito.anyLong(),Mockito.any());
    }

    @Test
    public void testPriceNotFound(){
        Mockito.when(pricesRepository.findByData(Mockito.anyLong(),Mockito.anyLong(),Mockito.any())).
                thenReturn(null);
        Assertions.assertThrows(PrecioNotFoundException.class,() -> priceService.obtenerPrecio(converLocalDate("2020-06-15 00:00:00"),35455L,1l));
        Mockito.verify(pricesRepository).findByData(Mockito.anyLong(),Mockito.anyLong(),Mockito.any());
    }


    private Prices cartgarDomi1() {
        long productId = 35455L;
        int brandId = 1;
        LocalDate date = LocalDate.of(2020, 6, 14);
        Prices price = new Prices();
        price.setProductId(productId);
        price.setEndDate(converLocalDate("2020-06-15 00:00:00"));
        price.setPrice(38.95);
        price.setStartDate(converLocalDate("2020-12-31 23:59:59"));
        price.setPriceList(4);
        price.setCurrency("EUR");
        price.setBrandId(1l);
        return price;
    }
    private PricesDTO cartgarDomiDto1() {
        long productId = 35455L;
        int brandId = 1;
        LocalDate date = LocalDate.of(2020, 6, 14);
        PricesDTO price = new PricesDTO();
        price.setProductId(productId);
        price.setEndDate(converLocalDate("2020-06-15 00:00:00"));
        price.setPrice(38.95);
        price.setStartDate(converLocalDate("2020-12-31 23:59:59"));
        price.setPriceList(4);
        price.setCurrency("EUR");
        price.setBrandId(1l);
        return price;
    }

    private LocalDateTime converLocalDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(string, formatter);
    }
}
