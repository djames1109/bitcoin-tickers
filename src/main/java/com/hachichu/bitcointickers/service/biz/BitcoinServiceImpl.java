package com.hachichu.bitcointickers.service.biz;

import com.hachichu.bitcointickers.dto.biz.BitcoinExchangeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by djames
 * 28/02/2021  2:26 AM
 */
@Service
public class BitcoinServiceImpl implements BitcoinService {

    private static final String USD_SYMBOL = "BTCUSD";
    private static final String bitcoinUrl = "https://api.exchange.bitcoin.com/api/2/public/ticker";
    private final RestTemplate restTemplate;

    public BitcoinServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BitcoinExchangeInfo getBitcoinExchangeInfo() {
        ResponseEntity<BitcoinExchangeInfo[]> response = restTemplate.getForEntity(bitcoinUrl, BitcoinExchangeInfo[].class);
        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .filter(r -> r.getSymbol().equalsIgnoreCase(USD_SYMBOL))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to fetch bitcoin exchange info for USD."));
    }
}
