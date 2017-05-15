package org.tac.tests.parse_time;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class ParseTime {
    public static void main(String[] s) {
        Calendar calDate = Calendar.getInstance();
        Date startDate = new Date(System.currentTimeMillis());

        ParsePosition pp = new ParsePosition(0);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date startTime = sdf.parse("01:00:00", pp);
        Calendar calTime = Calendar.getInstance();
        calTime.setTime(startTime);
        calDate.set(Calendar.HOUR_OF_DAY, calTime.get(Calendar.HOUR_OF_DAY));
        calDate.set(Calendar.MINUTE, calTime.get(Calendar.MINUTE));
        calDate.set(Calendar.SECOND, calTime.get(Calendar.SECOND));
        startDate = calDate.getTime();
        
        System.out.println("Debug: startDate = " + startDate);
    }
}
