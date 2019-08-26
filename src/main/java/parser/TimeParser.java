package parser;

import commons.DukeException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeParser {

    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HHmm");
        return dateFormat.format(date);
    }

    public static Date convertStringToDate(String str) throws DukeException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HHmm");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            throw new DukeException("Please enter date in correct format: dd-mm-yyyy hhmm. e.g. 18-12-1999 1800.");
        }
    }
}
