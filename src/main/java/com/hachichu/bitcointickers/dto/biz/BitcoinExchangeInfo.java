package com.hachichu.bitcointickers.dto.biz;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by djames
 * 28/02/2021  2:25 AM
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BitcoinExchangeInfo {
    private String name;
    private String symbol;
    private BigDecimal ask;
}
