package edu.tutorial.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateService {

    //    @Deprecated
    public Date getCurrentDate() {
        Date currentDate = new Date();
        return currentDate;
    }

    //    @Deprecated
    public void getSpecificDate(String date) {
        Date aDate = new Date(date);
        System.out.println("Specific date is: " + aDate);
    }

    public LocalDate getDateParsed(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

}
