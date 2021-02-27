package com.hachichu.bitcointickers.controller;

import com.hachichu.bitcointickers.dto.LowestSellingPrice;
import com.hachichu.bitcointickers.service.biz.BitcoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by djames
 * 28/02/2021  1:51 AM
 */
@Slf4j
@RequestMapping("/bitcoin/lowest-selling-price")
@RestController
public class BitcoinTickerController {

    private final BitcoinService bitcoinService;

    public BitcoinTickerController(BitcoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping
    public ResponseEntity<LowestSellingPrice> getLowestSellingPrice() {
        log.info("Response: {}", bitcoinService.getBitcoinExchangeInfo());

        return null;
    }
}
