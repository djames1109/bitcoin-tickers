package com.hachichu.bitcointickers.service;

import com.hachichu.bitcointickers.dto.LowestSellingPrice;
import com.hachichu.bitcointickers.dto.biz.BitcoinExchangeInfo;
import com.hachichu.bitcointickers.dto.biz.BlockchainExchangeInfo;
import com.hachichu.bitcointickers.service.biz.BitcoinService;
import com.hachichu.bitcointickers.service.biz.BlockchainService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

/**
 * Created by djames
 * 28/02/2021  3:00 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class AppProcessorTests {

    @InjectMocks
    public AppProcessorImpl appProcessor;

    @Mock
    public BitcoinService bitcoinService;

    @Mock
    public BlockchainService blockchainService;

    @Test
    public void testBitcoinLowestSellingPrice() throws Exception {
        Mockito.when(bitcoinService.getBitcoinExchangeInfo())
                .thenReturn(getBitcoinExchangeInfo("47514.89"));

        Mockito.when(blockchainService.getBlockchainExchangeInfo())
                .thenReturn(getBlockchainExchangeInfo("48923.89"));

        LowestSellingPrice lowestSellingPrice = appProcessor.getLowestSellingPrice();
        Assertions.assertTrue(lowestSellingPrice.getName().equalsIgnoreCase("Bitcoin"));
        Assertions.assertEquals(BigDecimal.valueOf(47514.89), lowestSellingPrice.getSellPrice());
    }

    @Test
    public void testBlockchainLowestSellingPrice() throws Exception {
        Mockito.when(bitcoinService.getBitcoinExchangeInfo())
                .thenReturn(getBitcoinExchangeInfo("49254.80"));

        Mockito.when(blockchainService.getBlockchainExchangeInfo())
                .thenReturn(getBlockchainExchangeInfo("45903.41"));

        LowestSellingPrice lowestSellingPrice = appProcessor.getLowestSellingPrice();
        Assertions.assertTrue(lowestSellingPrice.getName().equalsIgnoreCase("Blockchain"));
        Assertions.assertEquals(BigDecimal.valueOf(45903.41), lowestSellingPrice.getSellPrice());
    }

    private BitcoinExchangeInfo getBitcoinExchangeInfo(String value) {
        return BitcoinExchangeInfo.builder()
                .name("Bitcoin")
                .symbol("BTCUSD")
                .ask(new BigDecimal(value))
                .build();
    }

    private BlockchainExchangeInfo getBlockchainExchangeInfo(String value) {
        return BlockchainExchangeInfo.builder()
                .name("Blockchain")
                .symbol("USD")
                .sell(new BigDecimal(value))
                .build();
    }
}
