package com.rozbit.gifservice.resource;

import com.rozbit.gifservice.AbstractTest;
import com.rozbit.gifservice.enums.GifEnum;
import com.rozbit.gifservice.util.DateUtil;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class GifControllerTest extends AbstractTest {

    @Test
    public void controllerTest() throws Exception {
        Mockito.when(exchangeFeignService.getLatestCurrencyRates())
                .thenReturn(getUpCurrencyDto());
        Mockito.when(exchangeFeignService.getYesterdayCurrencyRates(new DateUtil().getYesterdayString()))
                .thenReturn(getLowCurrencyDto());
        Mockito.when(gifFeignService.getGifByTag(GifEnum.RICH.displayName())).thenReturn(getTestRichGifResponse());


        this.mvc.perform(get("/gif"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.url").value(GifEnum.RICH.displayName()));
    }

}
