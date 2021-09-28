package com.rozbit.gifservice.service;

import com.rozbit.gifservice.AbstractTest;
import com.rozbit.gifservice.enums.GifEnum;
import com.rozbit.gifservice.util.DateUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GifServiceImplTest extends AbstractTest {

    @Test
    public void expectRich_getGifResponseTest() {
        when(exchangeFeignService.getLatestCurrencyRates())
                .thenReturn(getUpCurrencyDto());
        when(exchangeFeignService.getYesterdayCurrencyRates(new DateUtil().getYesterdayString()))
                .thenReturn(getLowCurrencyDto());
        when(gifFeignService.getGifByTag(GifEnum.RICH.displayName())).thenReturn(getTestRichGifResponse());

        assertEquals(GifEnum.RICH.displayName(), gifService.getGifResponse().getData().getUrl());
    }

    @Test
    public void expectBroke_getGifResponseTest() {
        when(exchangeFeignService.getLatestCurrencyRates())
                .thenReturn(getLowCurrencyDto());
        when(exchangeFeignService.getYesterdayCurrencyRates(new DateUtil().getYesterdayString()))
                .thenReturn(getUpCurrencyDto());
        when(gifFeignService.getGifByTag(GifEnum.BROKE.displayName())).thenReturn(getTestBrokeGifResponse());

        assertEquals(GifEnum.BROKE.displayName(), gifService.getGifResponse().getData().getUrl());
    }

}