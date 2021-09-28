package com.rozbit.gifservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@ToString
public class CurrencyDto implements Serializable {

    private String disclaimer;
    private String base;
    private Map<String, BigDecimal> rates;

}
