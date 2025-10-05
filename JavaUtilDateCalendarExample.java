// JavaUtilDateCalendarExample.java

import java.util.Date;
import java.util.Calendar;

public class JavaUtilDateCalendarExample {
    public static void main(String[] args) {
        // Using Date class
        Date currentDate = new Date();
        System.out.println("Current Date and Time using Date: " + currentDate);

        // Using Calendar class
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // months are 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println("Current Date and Time using Calendar: " +
                day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second);
    }
}
