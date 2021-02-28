package com.hachichu.bitcointickers.service;

import com.hachichu.bitcointickers.dto.LowestSellingPrice;
import com.hachichu.bitcointickers.dto.biz.BitcoinExchangeInfo;
import com.hachichu.bitcointickers.dto.biz.BlockchainExchangeInfo;
import com.hachichu.bitcointickers.service.biz.BitcoinService;
import com.hachichu.bitcointickers.service.biz.BlockchainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by djames
 * 28/02/2021  1:56 AM
 */
@Slf4j
@Service
public class AppProcessorImpl implements AppProcessor {

    private final BitcoinService bitcoinService;
    private final BlockchainService blockchainService;

    public AppProcessorImpl(BitcoinService bitcoinService, BlockchainService blockchainService) {
        this.bitcoinService = bitcoinService;
        this.blockchainService = blockchainService;
    }

    @Override
    public LowestSellingPrice getLowestSellingPrice() {
        BitcoinExchangeInfo bitcoinInfo = bitcoinService.getBitcoinExchangeInfo();
        log.debug("bitcoinInfo: {}", bitcoinInfo);
        BlockchainExchangeInfo blockchainExchangeInfo = blockchainService.getBlockchainExchangeInfo();
        log.debug("blockchainInfo: {}", blockchainExchangeInfo);

        if (bitcoinInfo.getAsk().compareTo(blockchainExchangeInfo.getSell()) < 0) {
            return LowestSellingPrice.builder()
                    .name(bitcoinInfo.getName())
                    .sellPrice(bitcoinInfo.getAsk())
                    .build();
        } else {
            return LowestSellingPrice.builder()
                    .name(blockchainExchangeInfo.getName())
                    .sellPrice(blockchainExchangeInfo.getSell())
                    .build();
        }
    }
}
