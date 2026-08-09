package edu.tutorial.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateService {

    //    @Deprecated
    public void getCurrentDate() {
        Date currentDate = new Date();
        System.out.println("Current date is: " + currentDate);
    }

    //    @Deprecated
    public void getSpecificDate(String date) {
        Date aDate = new Date(date);
        System.out.println("Specific date is: " + aDate);
    }

    public void getDateParsed(String date, String format) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
        System.out.println("Date parsed is: " + localDate);
    }

}
