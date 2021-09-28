package com.rozbit.gifservice.service;

import com.rozbit.gifservice.dto.GifResponse;

/** *
 * Интерфейс GifService
 */
public interface GifService {

    /** *
     * Метод возвращает подходящую gif
     *
     * @return
     *      object {@link GifResponse}
     */
    GifResponse getGifResponse();
}
