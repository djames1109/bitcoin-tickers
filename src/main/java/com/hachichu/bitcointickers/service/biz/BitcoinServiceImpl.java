package com.hachichu.bitcointickers.service.biz;

import com.hachichu.bitcointickers.dto.biz.BitcoinExchangeInfo;
import org.springframework.beans.factory.annotation.Value;
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
    private final RestTemplate restTemplate;

    @Value("${bitcoin.api.url}")
    public String bitcoinUrl;

    public BitcoinServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BitcoinExchangeInfo getBitcoinExchangeInfo() {
        ResponseEntity<BitcoinExchangeInfo[]> response = restTemplate.getForEntity(bitcoinUrl, BitcoinExchangeInfo[].class);
        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .filter(r -> r.getSymbol().equalsIgnoreCase(USD_SYMBOL))
                .findFirst()
                .map(o -> {
                    o.setName("Bitcoin");
                    return o;
                })
                .orElseThrow(() -> new RuntimeException("Unable to fetch bitcoin exchange info for USD."));
    }
}
