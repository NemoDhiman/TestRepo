package utilities;

import org.junit.Assert;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

    public static String getDayOfDate(String date) {
        String parts[] = date.split("/");
        String day = parts[0];
        return day;
    }

    public static String getFullMonthNameOfDate(String date) {
        String parts[] = date.split("/");
        int monthNumber = Integer.parseInt(parts[1]);
        return new DateFormatSymbols().getMonths()[monthNumber - 1];
    }

    public static String getYearOfDate(String date) {
        String parts[] = date.split("/");
        String year = parts[2];
        return year;
    }

    public static String getMonthYearOfDate(String date) {
        String month = getFullMonthNameOfDate(date);
        String year = getYearOfDate(date);
        String monthYear = month + " " + year;
        return monthYear;
    }

    public static String getMonthYearOfDate_v1(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String desiredMonthYear = null;
        try {
            Date selectedDate = sdf.parse(date);
            String month = new SimpleDateFormat("MMMM").format(selectedDate);
            String year = new SimpleDateFormat("yyyy").format(selectedDate);
            desiredMonthYear = month + " " + year;
        } catch (ParseException e) {
            System.out.println("Parser Exception e:" + e);
        }
        return desiredMonthYear;
    }

    public static Date convertSelectedDateToDateObject(String date) {
        Date newDate = null;
        try {
            newDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return newDate;
    }

    public static String convertDateToFormatDDMMMYYYY(String stockDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        try {
            Date date = sdf.parse(stockDate);
            sdf = new SimpleDateFormat("dd-MMM-yyyy");
            return (sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        }


}

