package org.tac.tests.test_simple_date_format;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class TestSimpleDateFormat {
    public static void main(String[] s) {
        
        String version = System.getProperty("java.version");
        System.out.println("Debug: java.version = " + version);
        
        String TIME_FORMAT = "HH:mm:ss";
        String sStartTime = "";

        sStartTime = "01:00:00";
        Calendar calDate = Calendar.getInstance();

        ParsePosition pp = new ParsePosition(0);
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        Date startTime = sdf.parse(sStartTime, pp);
        Calendar calTime = Calendar.getInstance();
        calTime.setTime(startTime);
        calDate.set(Calendar.HOUR_OF_DAY, calTime.get(Calendar.HOUR_OF_DAY));
        calDate.set(Calendar.MINUTE, calTime.get(Calendar.MINUTE));
        calDate.set(Calendar.SECOND, calTime.get(Calendar.SECOND));
        
        System.out.println("Debug: calDate.getTime() = " + calDate.getTime());
    }
}
