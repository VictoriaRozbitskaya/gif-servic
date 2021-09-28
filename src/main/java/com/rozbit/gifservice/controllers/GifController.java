package com.rozbit.gifservice.controllers;

import com.rozbit.gifservice.dto.GifResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** *
 * Интерфейс GifController
 */
public interface GifController {

    /** *
     * Метод возвращает response с подходящей gif
     *
     * @return
     *      object {@link ResponseEntity<GifResponse>}
     */
    @GetMapping("/gif")
    @ResponseBody
    ResponseEntity<GifResponse> getActualGif();
}
