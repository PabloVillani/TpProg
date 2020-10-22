package Util;

import java.util.GregorianCalendar;

public class GregorianCalendarManager {
    Scanner scanner = new Scanner();
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;
    GregorianCalendar gc;
    public GregorianCalendarManager(){}
    public GregorianCalendarManager(int year, int month, int day, int hour){
        this.year = year;
        this.month = month;
        this.day = hour;
        GregorianCalendar gc = new GregorianCalendar(year,month,day,hour,0,0);
    }
    public int getYear() {
       return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public GregorianCalendar dateGenerator(){
        int year;
        int month;
        int day;
        int hour;
        year = scanner.getInt("Introduzca el año: ");
        month = scanner.getInt("Introduzca el mes en numeros (enero = 0, diciembre = 11)");
        month = validMonth(month);
        day = scanner.getInt("Introduzca el dia");
        day = validDay(month,day);
        hour = scanner.getInt("Introduzca la hora");
        hour = validHour(hour);
        return new GregorianCalendar(year,month,day,hour,0,0);
    }
    public int validMonth(int month){
        int month1 = month;
        if(month<0 || month>11){
            month1 = scanner.getInt("Introduzca el mes en numeros (enero = 0, diciembre = 11)");
            validMonth(month1);
        }
        return month1;
    }
    public int validDay(int month, int day){
        int day1 = day;
        if((month == 2 && day > 29) || ((month == 4 || month == 6 || month == 9 || month == 11) && day>30) || ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day>31)){
            System.out.println("Fecha invalida");
            day1 = scanner.getInt("Introduzca el dia");
        }
        return day1;
    }
    public int validHour(int hour){
        int hour1 = hour;
        if(hour < 0 || hour > 23){
            System.out.println("Hora invalida");
            hour1 = scanner.getInt("Introduzca el dia");
        }
        return hour1;
    }
    public String gCToString(GregorianCalendarManager gc){
        return gc.getDay() + "-" + gc.getMonth() + "-" + gc.getYear() + " " + gc.getHour() + ":0:0";
    }
}
