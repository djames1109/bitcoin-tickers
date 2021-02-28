package com.hachichu.bitcointickers.dto.biz;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by djames
 * 28/02/2021  11:05 AM
 */
@Data
@Builder
public class BlockchainExchangeInfo {
    private String name;
    private String symbol;
    private BigDecimal sell;
}
