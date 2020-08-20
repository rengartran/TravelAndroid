package com.neptuunia.travel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    public static final String DATE_STRING_FORMAT = "%s-%s-%s";

    public static final String DATE_FORMAT = "dd-MM-yyyy";

    public static final String TIME_STRING_FORMAT = "%s:%s";

    public static final String TIME_FORMAT = "HH:mm";

    private DateTimeUtils() {
        // Prevent outside instantiation
    }

    public static long parseToMillis(String dateString, String time) {
        try {
            String datetime = dateString + " " + time;
            String pattern = DATE_FORMAT + " " + TIME_FORMAT;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
            Date date = simpleDateFormat.parse(datetime);

            if (date != null) {
                return date.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}