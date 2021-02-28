package com.hachichu.bitcointickers.service.biz;

import com.hachichu.bitcointickers.dto.biz.BlockchainExchangeInfo;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by djames
 * 28/02/2021  11:07 AM
 */
@Service
public class BlockchainServiceImpl implements BlockchainService {

    private static final String USD_SYMBOL = "USD";
    private final RestTemplate restTemplate;

    @Value("${blockchain.api.url}")
    public String blockchainUrl;

    public BlockchainServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BlockchainExchangeInfo getBlockchainExchangeInfo() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(blockchainUrl, String.class);
        JSONObject usdExchangeInfo = new JSONObject(responseEntity.getBody()).getJSONObject(USD_SYMBOL);
        return BlockchainExchangeInfo.builder()
                .name("Blockchain")
                .symbol(USD_SYMBOL)
                .sell(usdExchangeInfo.getBigDecimal("sell"))
                .build();
    }
}
