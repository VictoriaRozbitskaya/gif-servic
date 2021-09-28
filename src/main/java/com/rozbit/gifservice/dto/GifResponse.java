package com.rozbit.gifservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class GifResponse implements Serializable {

    private GifDataDto data;
    private Object meta;

}
