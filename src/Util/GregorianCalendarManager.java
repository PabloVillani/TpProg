package Util;

import java.util.GregorianCalendar;

public class GregorianCalendarManager {
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    Scanner scanner = new Scanner();
    ArrayMaker arrayMaker = new ArrayMaker();

    public GregorianCalendarManager(){}

    public GregorianCalendar stringToGc(String s){
        String[] dateArray = s.split("-");
        Integer day = Integer.parseInt(dateArray[0]);
        Integer month = Integer.parseInt(dateArray[1]);
        String[] hourArray = dateArray[2].split("~");
        Integer year = Integer.parseInt(hourArray[0]);
        Integer hour = Integer.parseInt(hourArray[1]);
        return new GregorianCalendar();
    }
}

