package com.rozbit.gifservice.service;

import com.rozbit.gifservice.dto.CurrencyDto;
import com.rozbit.gifservice.dto.GifResponse;
import com.rozbit.gifservice.enums.GifEnum;
import com.rozbit.gifservice.feignclients.ExchangeRatesFeign;
import com.rozbit.gifservice.feignclients.GifFeign;
import com.rozbit.gifservice.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class GifServiceImpl implements GifService {

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private ExchangeRatesFeign exchangeRatesFeign;
    @Autowired
    private GifFeign gifFeign;

    @Override
    public GifResponse getGifResponse() {

        CurrencyDto responseLatest = exchangeRatesFeign.getLatestCurrencyRates();
        CurrencyDto responseHistory = exchangeRatesFeign.getYesterdayCurrencyRates(dateUtil.getYesterdayString());
        log.info("{}", responseLatest);
        log.info("{}", responseHistory);

        if (responseLatest == null || responseHistory == null) {
            return null;
        }
        String tag = getTag(responseLatest, responseHistory);
        log.info("Tag is: "+ tag);

        GifResponse gif = gifFeign.getGifByTag(tag);
        log.info("{}", gif);

        return gif;
    }

    private String getTag(CurrencyDto latest, CurrencyDto history) {

        String currencySymbol = GifEnum.RUB.displayName();

        BigDecimal latestRate = latest.getRates().get(currencySymbol);
        BigDecimal historyRate = history.getRates().get(currencySymbol);

        if (latestRate.compareTo(historyRate) > 0) {
            return GifEnum.RICH.displayName();
        }
        return GifEnum.BROKE.displayName();
    }

}
