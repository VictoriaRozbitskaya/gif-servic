package com.rozbit.gifservice.feignclients;

import com.rozbit.gifservice.dto.GifResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** *
 * Feign клиент для работы с внешним сервисом GIPHY
 * @see <a href="https://developers.giphy.com/">Giphy</a>
 */
@FeignClient(name = "GIF", url = "${giphy.url}")
public interface GifFeign {

    /**
     * Метод возвращает рандомную gif в соответствии с тегом
     *
     * @param tag
     *      object {@link String}
     * @return
     *      object {@link GifResponse}
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "random?api_key=${giphy.id}&tag={tag}&rating=${giphy.rating}")
    GifResponse getGifByTag(@PathVariable String tag);
}
