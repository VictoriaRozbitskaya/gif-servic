package com.rozbit.gifservice;

import com.rozbit.gifservice.dto.CurrencyDto;
import com.rozbit.gifservice.dto.GifDataDto;
import com.rozbit.gifservice.dto.GifResponse;
import com.rozbit.gifservice.enums.GifEnum;
import com.rozbit.gifservice.feignclients.ExchangeRatesFeign;
import com.rozbit.gifservice.feignclients.GifFeign;
import com.rozbit.gifservice.service.GifService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractTest {

    protected List<CurrencyDto> currencyDtos = new ArrayList<>();
    protected List<GifResponse> gifResponses = new ArrayList<>();

    {
        initLists();
    }

    @Autowired
    protected GifService gifService;

    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected ExchangeRatesFeign exchangeFeignService;

    @MockBean
    protected GifFeign gifFeignService;

    public CurrencyDto getUpCurrencyDto() {
        return currencyDtos.get(0);
    }
    public CurrencyDto getLowCurrencyDto(){
        return currencyDtos.get(1);
    }
    public GifResponse getTestRichGifResponse() {
        return gifResponses.get(0);
    }
    public GifResponse getTestBrokeGifResponse() {
        return gifResponses.get(1);
    }

    private void initLists() {
        CurrencyDto testUpCurrency = new CurrencyDto();
        testUpCurrency.setRates(new HashMap<>());
        testUpCurrency.getRates().put(GifEnum.RUB.displayName(), new BigDecimal("77.703"));
        currencyDtos.add(testUpCurrency);

        CurrencyDto testLowCurrency = new CurrencyDto();
        testLowCurrency.setRates(new HashMap<>());
        testLowCurrency.getRates().put(GifEnum.RUB.displayName(), new BigDecimal("75.505"));
        currencyDtos.add(testLowCurrency);

        GifResponse testRichGif = new GifResponse();
        GifDataDto testRichGifDataDto = new GifDataDto();
        testRichGifDataDto.setUrl(GifEnum.RICH.displayName());
        testRichGif.setData(testRichGifDataDto);
        gifResponses.add(testRichGif);

        GifResponse testBrokeGif = new GifResponse();
        GifDataDto testBrokeGifDataDto = new GifDataDto();
        testBrokeGifDataDto.setUrl(GifEnum.BROKE.displayName());
        testBrokeGif.setData(testBrokeGifDataDto);
        gifResponses.add(testBrokeGif);
    }
}
