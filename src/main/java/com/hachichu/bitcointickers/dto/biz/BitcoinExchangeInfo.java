package com.hachichu.bitcointickers.dto.biz;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by djames
 * 28/02/2021  2:25 AM
 */
@Data
public class BitcoinExchangeInfo {
    private String name = "Bitcoin";
    private String symbol;
    private BigDecimal ask;
}
