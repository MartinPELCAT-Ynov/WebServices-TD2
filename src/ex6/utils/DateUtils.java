package ex6.utils;

import java.util.Date;

public class DateUtils {


    public static boolean isDateBetween(Date covidTest, Date dateToTest) {
        return dateToTest.before(covidTest) && dateToTest.after(new Date(covidTest.getTime() - 7 * 24 * 60 * 60 * 1000));
    }

}
