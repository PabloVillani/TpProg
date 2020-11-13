package Util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class DateManager {
    Scanner scanner = new Scanner();
    ArrayMaker arrayMaker = new ArrayMaker();

    public DateManager() {
    }

    public LocalDateTime dateGenerator() {
        Integer year;
        Integer month;
        Integer day;
        Integer hour;
        year = scanner.getInt("Introduzca el año: ");
        month = scanner.getInt("Introduzca el mes en numeros:");
        month = validMonth(month);
        day = scanner.getInt("Introduzca el dia: ");
        //day = validDay(month,day);
        hour = scanner.getInt("Introduzca la hora: ");
        hour = validHour(hour);
        return LocalDateTime.of(year, month, day, hour, 0, 0);
    }

    public Integer validMonth(Integer month) {
        Integer month1 = month;
        if (month < 1 || month > 12) {
            System.out.println("Mes invalido.");
            month1 = scanner.getInt("Introduzca el mes en numeros (enero = 0, diciembre = 11): ");
            validMonth(month1);
        }
        return month1;
    }

    public Integer validDay(Integer year, Integer month, Integer day) {
        Integer day1 = day;
        if (day > daysInAMonth(month, year)) {
            System.out.println("Dia invalido.");
            day1 = scanner.getInt("Introduzca el Dia en numeros: ");
            validMonth(day1);
        }
        return day1;
    }

    public Integer daysInAMonth(Integer month, Integer year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isleapYear(year)) {
                    return 30;
                } else {
                    return 28;
                }
            default:
                return null;

        }
    }

    private boolean isleapYear(int year) {
        return ((year % 4 == 0) && !(year % 100 == 0)) || year % 400 == 0;
    }

    public Integer validHour(Integer hour) {
        Integer hour1 = hour;
        if (hour < 0 || hour > 23) {
            System.out.println("Hora invalida.");
            hour1 = scanner.getInt("Introduzca el dia");
        }
        return hour1;
    }

    public String dateToString(LocalDateTime date) {
        return date.getDayOfMonth() + "-" + date.getMonth() + "-" + date.getYear() + "~" + date.getHour() + ":" + 0 + ":" + 0;
    }

    public LocalDateTime stringToDate(String s) {
        String[] dateArray = s.split("-");
        Integer day = Integer.parseInt(dateArray[0]);
        Integer month = Integer.parseInt(monthNameToString(dateArray[1]));
        String[] yearHourArray = dateArray[2].split("~");
        Integer year = Integer.parseInt(yearHourArray[0]);
        String[] hourArray = yearHourArray[1].split(":");
        Integer hour = Integer.parseInt(hourArray[0]);
        Integer minutes = Integer.parseInt(hourArray[1]);
        Integer seconds = Integer.parseInt(hourArray[2]);
        return LocalDateTime.of(year, month, day, hour, minutes, seconds);
    }

    public boolean fourtyEightHoursBetweenDates(LocalDateTime date1Start, LocalDateTime date2End) {
        if (date1Start.isBefore(date2End)) {
            long hours = ChronoUnit.HOURS.between(date1Start, date2End);
            return hours <= 48;
        } else {
            return false;
        }
    }
    public boolean twentyFourHoursBetweenDates(LocalDateTime date1Start, LocalDateTime date2End){
        if (date1Start.isBefore(date2End)) {
            long hours = ChronoUnit.HOURS.between(date1Start, date2End);
            return hours <= 24;
        } else {
            return false;
        }
    }

    public String monthNameToString(String month){
        String i = "0";
        switch (month){
            case "JANUARY":
                i="1";
                break;
            case "FEBRUARY":
                 i="2";
                break;
            case "MARCH":
                i="3";
                break;
            case "APRIL":
                 i="4";
                break;
            case "MAY":
                 i="5";
                break;
            case "JUNE":
                 i="6";
                break;
            case "JULY":
                i="7";
                break;
            case "AUGUST":
                 i="8";
                break;
            case "SEPTEMBER":
                 i="9";
                break;
            case "OCTOBER":
                 i="10";
                break;
            case "NOVEMBER":
                 i="11";
                break;
            case "DECEMBER":
                i="12";
                break;
        }
        return i;
    }
}

