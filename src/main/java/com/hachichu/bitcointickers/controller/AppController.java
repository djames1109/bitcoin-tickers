package com.hachichu.bitcointickers.controller;

import com.hachichu.bitcointickers.dto.LowestSellingPrice;
import com.hachichu.bitcointickers.service.AppProcessor;
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
public class AppController {

    private final AppProcessor processor;

    public AppController(AppProcessor processor) {
        this.processor = processor;
    }

    @GetMapping
    public ResponseEntity<LowestSellingPrice> getLowestSellingPrice() {
        LowestSellingPrice lowestSellingPrice = processor.getLowestSellingPrice();
        log.info("Name={}, SellPrice={}", lowestSellingPrice.getName(), lowestSellingPrice.getSellPrice());

        return ResponseEntity.ok(lowestSellingPrice);
    }
}
