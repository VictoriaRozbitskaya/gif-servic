package com.rozbit.gifservice.resource;

import com.rozbit.gifservice.controllers.GifController;
import com.rozbit.gifservice.dto.GifResponse;
import com.rozbit.gifservice.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GifControllerImpl implements GifController {

    @Autowired
    private GifService service;

    @GetMapping("/gif")
    public ResponseEntity<GifResponse> getActualGif() {
        GifResponse gif = service.getGifResponse();
        return new ResponseEntity<>(gif, HttpStatus.OK);
    }
}
