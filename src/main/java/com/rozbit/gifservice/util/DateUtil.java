package com.rozbit.gifservice.util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateUtil {

        private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getYesterdayString() {
        return dateFormat.format(getYesterday());
    }

    private Date getYesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}

