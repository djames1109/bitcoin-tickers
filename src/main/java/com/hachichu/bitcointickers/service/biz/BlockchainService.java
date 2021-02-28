package com.hachichu.bitcointickers.service.biz;

import com.hachichu.bitcointickers.dto.biz.BlockchainExchangeInfo;

/**
 * Created by djames
 * 28/02/2021  11:04 AM
 */
public interface BlockchainService {

    BlockchainExchangeInfo getBlockchainExchangeInfo();
}
