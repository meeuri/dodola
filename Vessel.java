package com.example.eery.dodola;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Vessel {
    public static final int DATA_MULIPLIER = 1000;

    public static String convertDate(long milliSeconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds * DATA_MULIPLIER);
        return formatter.format(calendar.getTime());
    }

    public static String convertIconName(String name){
        String newName = "ic_" + name.replace("-","_");
        return newName;
    }
}
