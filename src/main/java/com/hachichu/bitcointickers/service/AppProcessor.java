package com.hachichu.bitcointickers.service;

import com.hachichu.bitcointickers.dto.LowestSellingPrice;

/**
 * Created by djames
 * 28/02/2021  1:55 AM
 */
public interface AppProcessor {

    LowestSellingPrice getLowestSellingPrice();
}
