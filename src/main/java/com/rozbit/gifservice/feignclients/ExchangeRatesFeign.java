package com.rozbit.gifservice.feignclients;

import com.rozbit.gifservice.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** *
 * Feign клиент для работы с внешним сервисом Open Exchange Rates
 * @see <a href="https://docs.openexchangerates.org/>Open Exchange Rates</a>
 */
@FeignClient(value = "exchangeRates", url = "${exchange.url}")
public interface ExchangeRatesFeign {

    /** *
     * Метод возвращает актуальный курс валют
     *
     * @return
     *      object {@link CurrencyDto}
     */
    @RequestMapping(method = RequestMethod.GET, value = "latest.json?${exchange.query}")
    CurrencyDto getLatestCurrencyRates();

    /**
     * Метод возвращает вчерашний курс валют
     *
     * @param date дата в формате YYYY-MM-DD
     *      object {@link String}
     * @return
     *      object {@link CurrencyDto}
     */
    @RequestMapping(method = RequestMethod.GET, value = "historical/{date}.json?${exchange.query}")
    CurrencyDto getYesterdayCurrencyRates(@PathVariable String date);
}
