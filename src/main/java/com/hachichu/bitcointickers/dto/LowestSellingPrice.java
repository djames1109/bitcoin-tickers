package com.hachichu.bitcointickers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by djames
 * 28/02/2021  1:53 AM
 */
@Setter
@Getter
@Builder
public class LowestSellingPrice {

    private String name;
    private BigDecimal sellPrice;
}
