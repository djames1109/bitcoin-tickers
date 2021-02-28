package com.hachichu.bitcointickers.dto.biz;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by djames
 * 28/02/2021  11:05 AM
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlockchainExchangeInfo {
    private String name;
    private String symbol;
    private BigDecimal sell;
}
