package Util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class DateManager {
    Scanner scanner = new Scanner();
    ArrayMaker arrayMaker = new ArrayMaker();
    Integer year;
    Integer month;
    Integer day;
    Integer hour;
    Integer minute;
    Integer second;

    public DateManager(){}

    public LocalDateTime dateGenerator(){
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
        return LocalDateTime.of(year,month,day, hour, 0, 0);
    }

    public Integer validMonth(Integer month){
        Integer month1 = month;
        if(month<1 || month>12){
            System.out.println("Mes invalido.");
            month1 = scanner.getInt("Introduzca el mes en numeros (enero = 0, diciembre = 11): ");
            validMonth(month1);
        }
        return month1;
    }

//    public Integer validDay(Integer month, Integer day){
//
//    }

    public Integer validHour(Integer hour){
        Integer hour1 = hour;
        if(hour < 0 || hour > 23){
            System.out.println("Hora invalida.");
            hour1 = scanner.getInt("Introduzca el dia");
        }
        return hour1;
    }
    public String dateToString(LocalDateTime date){
        return date.getDayOfMonth() + "-" + date.getMonth() + "-" + date.getYear() + "~" + date.getHour() + ":" + 0 + ":" + 0;
    }

    public LocalDateTime stringToDate(String s){
        String[] dateArray = s.split("-");
        Integer day = Integer.parseInt(dateArray[0]);
        Integer month = Integer.parseInt(dateArray[1]);
        String[] hourArray = dateArray[2].split("~");
        Integer year = Integer.parseInt(hourArray[0]);
        Integer hour = Integer.parseInt(hourArray[1]);
        return LocalDateTime.of(year,month,day,hour,0,0);
    }

    public boolean fourtyEightHoursBetweenDates(LocalDateTime date1Start, LocalDateTime date2End) {
        if (date1Start.isBefore(date2End)) {
            long hours = ChronoUnit.HOURS.between(date1Start, date2End);
            return hours >= 2;
        }
        else  return false;   }
}

