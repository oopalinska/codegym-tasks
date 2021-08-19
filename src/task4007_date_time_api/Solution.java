package task4007_date_time_api;

/*
Working with Java 8's DateTime API

*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = getDateFormat(date);
        try {
            calendar.setTime(dateFormat.parse(date));
            if (date.contains(".")) {
                System.out.println("Day: " + calendar.get(Calendar.DATE));
                System.out.println("Day of the week: " + (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
                System.out.println("Day of the month: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("Day of the year: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Week of the month: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Week of the year: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Month: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Year: " + calendar.get(Calendar.YEAR));
            }
            if (date.contains(":")) {
                System.out.println("AM or PM: " +(calendar.get(Calendar.AM_PM) == Calendar.PM ? "PM" : "AM"));
                System.out.println("Hour: " + calendar.get(Calendar.HOUR));
                System.out.println("Hour of the day: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Minutes: " + calendar.get(Calendar.MINUTE));
                System.out.println("Seconds: " + calendar.get(Calendar.SECOND));
            }
        } catch (ParseException ignored) {

        }
    }

    private static SimpleDateFormat getDateFormat(final String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        if (!date.contains(":")) {
            dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        } else if (!date.contains(".")) {
            dateFormat = new SimpleDateFormat("HH:mm:ss");
        }
        return dateFormat;
    }
}